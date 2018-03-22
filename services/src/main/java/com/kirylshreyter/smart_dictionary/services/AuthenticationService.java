package com.kirylshreyter.smart_dictionary.services;

import com.kirylshreyter.smart_dictionary.services.security.Authentication;
import com.kirylshreyter.smart_dictionary.services.security.Credentials;

public interface AuthenticationService {

	public Authentication authenticate(Credentials credentials);

	public Authentication authenticate(String token);

	public Credentials resolveCredentials(String base64encodedString);

	public boolean nullifyAuthentication(String token);

	public String generateToken();
	
	public String generateToken(String passPhrase);

}
