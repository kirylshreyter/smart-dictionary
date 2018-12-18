package com.kirylshreyter.smart_dictionary.services;

import com.kirylshreyter.smart_dictionary.services.security.Authentication;
import com.kirylshreyter.smart_dictionary.services.security.Credentials;

public interface AuthenticationService {

    Authentication authenticate(Credentials credentials);

    Authentication authenticate(String token);

    Credentials resolveCredentials(String base64encodedString);

    boolean nullifyAuthentication(String token);

    String generateToken();

    String generateToken(String passPhrase);

}
