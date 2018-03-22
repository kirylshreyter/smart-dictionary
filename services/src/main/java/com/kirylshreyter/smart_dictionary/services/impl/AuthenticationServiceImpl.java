package com.kirylshreyter.smart_dictionary.services.impl;

import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kirylshreyter.smart_dictionary.datamodel.IUser;
import com.kirylshreyter.smart_dictionary.services.AuthenticationService;
import com.kirylshreyter.smart_dictionary.services.UserService;
import com.kirylshreyter.smart_dictionary.services.security.Authentication;
import com.kirylshreyter.smart_dictionary.services.security.Credentials;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private UserService userService;

	public Authentication authenticate(Credentials credentials) {
		Authentication auth = new Authentication();
		auth.setUser(userService.findByEmailAndPassword(credentials.getEmail(), credentials.getPassword()));
		if (auth.getUser() == null) {
			return auth;
		}
		auth.getUser().setToken(generateToken());

		auth.setAuthenticated(true);
		auth.setToken(auth.getUser().getToken());
		userService.setFixedTokenFor(auth.getUser().getToken(), auth.getUser().getId());
		return auth;
	}

	public Credentials resolveCredentials(String base64encodedString) {
		Credentials credentials = new Credentials();
		if (base64encodedString == null) {
			return credentials;
		}
		byte[] resolved;
		try {
			resolved = Base64.getDecoder().decode(base64encodedString);
		} catch (IllegalArgumentException e) {
			return credentials;
		}
		String[] decodedString = new String(resolved).split(":");
		IUser user = userService.findByEmailAndPassword(decodedString[0], DigestUtils.sha256Hex(decodedString[1]));
		if (user == null) {
			return credentials;
		}
		credentials.setEmail(user.getEmail());
		credentials.setPassword(user.getPassword());
		return credentials;
	}

	public Authentication authenticate(String token) {
		Authentication auth = new Authentication();
		auth.setUser(userService.findByToken(token));
		if (auth.getUser() == null) {
			return auth;
		}
		auth.setAuthenticated(true);
		auth.setToken(auth.getUser().getToken());
		return auth;
	}

	public boolean nullifyAuthentication(String token) {
		Authentication authentication = authenticate(token);
		if (!authentication.isAuthenticated()) {
			return false;
		}
		return resetToken(authentication.getUser());
	}

	private boolean resetToken(IUser user) {
		String resettedToken = generateToken();
		user.setToken(resettedToken);
		IUser updatedUser = userService.create(user);
		if (updatedUser != null) {
			return true;
		}
		return false;
	}

	@Override
	public String generateToken() {
		Long random = ThreadLocalRandom.current().nextLong();
		ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
		buffer.putLong(random);
		String token = DigestUtils.sha256Hex(buffer.array());
		if (userService.findByToken(token) == null) {
			return token;
		}
		return generateToken();
	}

	@Override
	public String generateToken(String passPhrase) {
		return DigestUtils.sha256Hex(passPhrase);
	}

}
