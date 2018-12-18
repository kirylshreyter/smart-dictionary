package com.kirylshreyter.smart_dictionary.webapp.controllers;

import com.kirylshreyter.smart_dictionary.datamodel.IUser;
import com.kirylshreyter.smart_dictionary.services.AuthenticationService;
import com.kirylshreyter.smart_dictionary.services.UserService;
import com.kirylshreyter.smart_dictionary.services.security.Authentication;
import com.kirylshreyter.smart_dictionary.services.security.Credentials;
import com.kirylshreyter.smart_dictionary.webapp.config.Constants;
import com.kirylshreyter.smart_dictionary.webapp.config.Messages;
import com.kirylshreyter.smart_dictionary.webapp.config.Permissions;
import com.kirylshreyter.smart_dictionary.webapp.config.RoutesConfig;
import com.kirylshreyter.smart_dictionary.webapp.models.UserModel;
import com.kirylshreyter.smart_dictionary.webapp.models.security.AuthHeader;
import com.kirylshreyter.smart_dictionary.webapp.models.security.AuthenticationModel;
import com.kirylshreyter.smart_dictionary.webapp.models.security.BadAuthenticationModel;
import com.kirylshreyter.smart_dictionary.webapp.models.security.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(RoutesConfig.HOME_PATH)
@CrossOrigin(origins = Permissions.CORS_ORIGIN_URI)
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = RoutesConfig.SIGN_IN_PATH, method = RequestMethod.POST)
    public ResponseEntity<?> signIn(@RequestHeader(Constants.AUTH_HEADER) AuthHeader authHeader) {
        Credentials credentials = authenticationService.resolveCredentials(authHeader.getBase64encodedCredentials());
        Authentication authentication = authenticationService.authenticate(credentials);
        if (!authentication.isAuthenticated()) {
            return new ResponseEntity<>(
                    new BadAuthenticationModel(Messages.INVALID_USERNAME_OR_PASSWORD_ERROR), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new AuthenticationModel(authentication.getToken()),
                HttpStatus.OK);
    }

    @RequestMapping(value = RoutesConfig.SIGN_OUT_PATH, method = RequestMethod.DELETE)
    public ResponseEntity<?> signOut(@RequestHeader(Constants.X_AUTH_TOKEN_HEADER) String tokenHeader) {
        boolean reset = authenticationService.nullifyAuthentication(tokenHeader);
        if (!reset) {
            return new ResponseEntity<>(
                    new BadAuthenticationModel(Messages.INVALID_USERNAME_OR_PASSWORD_ERROR), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = RoutesConfig.SIGN_UP_PATH, method = RequestMethod.POST)
    public ResponseEntity<?> signUp(@RequestBody UserModel userModel) {
        if (userService.findByEmail(userModel.getEmail()) != null) {
            return new ResponseEntity<>(new BadAuthenticationModel(Messages.EMAIL_EXISTS_ERROR),
                    HttpStatus.BAD_REQUEST);
        }
        userModel.setToken(authenticationService.generateToken());
        IUser user = this.conversionService.convert(userModel, IUser.class);
        user = userService.create(user);
        Authentication auth = authenticationService.authenticate(user.getToken());
        if (!auth.isAuthenticated()) {
            return new ResponseEntity<>(
                    new BadAuthenticationModel(Messages.COMMON_ERROR), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new AuthenticationModel(auth.getToken()), HttpStatus.OK);
    }

    @RequestMapping(value = RoutesConfig.VALIDATE_TOKEN_PATH, method = RequestMethod.GET)
    public ResponseEntity<?> check(@RequestHeader(Constants.X_AUTH_TOKEN_HEADER) String token) {
        IUser user = userService.findByToken(token);
        return new ResponseEntity<>(new Check(user != null), HttpStatus.OK);
    }
}
