package com.kirylshreyter.smart_dictionary.webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kirylshreyter.smart_dictionary.datamodel.IUser;
import com.kirylshreyter.smart_dictionary.services.AuthenticationService;
import com.kirylshreyter.smart_dictionary.services.UserService;
import com.kirylshreyter.smart_dictionary.services.security.Authentication;
import com.kirylshreyter.smart_dictionary.services.security.Credentials;
import com.kirylshreyter.smart_dictionary.webapp.config.RoutesConfig;
import com.kirylshreyter.smart_dictionary.webapp.models.UserModel;
import com.kirylshreyter.smart_dictionary.webapp.models.security.AuthHeader;
import com.kirylshreyter.smart_dictionary.webapp.models.security.AuthenticationModel;
import com.kirylshreyter.smart_dictionary.webapp.models.security.BadAuthenticationModel;

@RestController
@RequestMapping(RoutesConfig.HOME_PATH)
public class AuthenticationController {

	@Autowired
	private AuthenticationService authenticationService;

	@Autowired
	private ConversionService conversionService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = RoutesConfig.SIGN_IN_PATH, method = RequestMethod.POST)
	public ResponseEntity<?> signIn(@RequestHeader("authorization") AuthHeader authHeader) {
		Credentials credentials = authenticationService.resolveCredentials(authHeader.getBase64encodedCredentials());
		Authentication authentication = authenticationService.authenticate(credentials);
		if (!authentication.isAuthenticated()) {
			return new ResponseEntity<BadAuthenticationModel>(
					new BadAuthenticationModel("Invalid username or password"), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<AuthenticationModel>(new AuthenticationModel(authentication.getToken()),
				HttpStatus.OK);
	}

	@RequestMapping(value = RoutesConfig.SIGN_OUT_PATH, method = RequestMethod.DELETE)
	public ResponseEntity<?> signOut(@RequestHeader("x-auth-token") String tokenHeader) {
		boolean resetted = authenticationService.nullifyAuthentication(tokenHeader);
		if (!resetted) {
			return new ResponseEntity<BadAuthenticationModel>(
					new BadAuthenticationModel("Invalid username or password"), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = RoutesConfig.SIGN_UP_PATH, method = RequestMethod.POST)
	public ResponseEntity<?> signUp(@RequestBody UserModel userModel) {
		if (userService.findByEmail(userModel.getEmail()) != null) {
			return new ResponseEntity<BadAuthenticationModel>(
					new BadAuthenticationModel("Email already exist."), HttpStatus.BAD_REQUEST);
		}
		userModel.setToken(authenticationService.generateToken());
		IUser user = this.conversionService.convert(userModel, IUser.class);
		user = userService.create(user);
		Authentication auth = authenticationService.authenticate(user.getToken());
		if (!auth.isAuthenticated()) {
			return new ResponseEntity<BadAuthenticationModel>(
					new BadAuthenticationModel("Something go wrong. Please, try again later."), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<AuthenticationModel>(new AuthenticationModel(auth.getToken()), HttpStatus.OK);
	}

}
