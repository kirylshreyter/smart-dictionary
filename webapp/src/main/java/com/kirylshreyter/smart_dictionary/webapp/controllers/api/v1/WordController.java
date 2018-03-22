package com.kirylshreyter.smart_dictionary.webapp.controllers.api.v1;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kirylshreyter.smart_dictionary.datamodel.IUser;
import com.kirylshreyter.smart_dictionary.datamodel.IWord;
import com.kirylshreyter.smart_dictionary.services.UserService;
import com.kirylshreyter.smart_dictionary.services.WordService;
import com.kirylshreyter.smart_dictionary.webapp.config.RoutesConfig;
import com.kirylshreyter.smart_dictionary.webapp.models.WordModel;
import com.kirylshreyter.smart_dictionary.webapp.utils.ResponseUtils;

@RestController
@RequestMapping(RoutesConfig.API_V1_WORDS_PATH)
public class WordController {

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private WordService wordService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<WordModel> createWord(@RequestBody WordModel wordModel,
	    @RequestHeader("x-auth-token") String token) {
	IUser user = userService.findByToken(token);
	IWord word = this.conversionService.convert(wordModel, IWord.class);
	word.setUser(user);
	return new ResponseEntity<WordModel>(this.conversionService.convert(wordService.create(word), WordModel.class),
		HttpStatus.OK);
    }

    @RequestMapping(value = "/{wordId}", method = RequestMethod.GET)
    public ResponseEntity<?> readWord(@PathVariable long wordId, @RequestHeader("x-auth-token") String token) {
	IUser user = userService.findByToken(token);
	IWord word = wordService.findByIdAndUserId(wordId, user.getId());
	if (word == null) {
	    return ResponseUtils.getInstance().restrictedResponse();
	}
	return new ResponseEntity<WordModel>(this.conversionService.convert(word, WordModel.class), HttpStatus.OK);
    }

    @RequestMapping(value = "/{wordId}", method = RequestMethod.PATCH)
    public ResponseEntity<?> updateWord(@PathVariable long wordId, @RequestBody WordModel wordModel,
	    @RequestHeader("x-auth-token") String token) {
	IUser user = userService.findByToken(token);
	IWord word = wordService.findByIdAndUserId(wordId, user.getId());
	if (word == null) {
	    return ResponseUtils.getInstance().restrictedResponse();
	}
	word = wordService
		.create(wordService.updateFields(this.conversionService.convert(wordModel, IWord.class), word));
	return new ResponseEntity<WordModel>(this.conversionService.convert(word, WordModel.class), HttpStatus.OK);
    }

    @RequestMapping(value = "/{wordId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteWord(@PathVariable long wordId, @RequestHeader("x-auth-token") String token) {
	IUser user = userService.findByToken(token);
	IWord word = wordService.findByIdAndUserId(wordId, user.getId());
	if (word == null) {
	    return ResponseUtils.getInstance().restrictedResponse();
	}
	wordService.delete(word);
	return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAllWords(@RequestHeader("x-auth-token") String token) {
	IUser user = userService.findByToken(token);
	List<IWord> dbWords = wordService.findAllByUserId(user.getId());
	List<WordModel> result = dbWords.stream().map(s -> this.conversionService.convert(s, WordModel.class))
		.collect(Collectors.toList());
	return new ResponseEntity<List<WordModel>>(result, HttpStatus.OK);
    }

}
