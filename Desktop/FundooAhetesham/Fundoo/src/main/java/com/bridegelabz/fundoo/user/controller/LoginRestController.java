package com.bridegelabz.fundoo.user.controller;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bridegelabz.fundoo.exception.RegistrationExceptions;
import com.bridegelabz.fundoo.response.Response;
import com.bridegelabz.fundoo.response.ResponseToken;
import com.bridegelabz.fundoo.user.dto.LoginDto;
import com.bridegelabz.fundoo.user.dto.UserDto;
import com.bridegelabz.fundoo.user.model.User;
import com.bridegelabz.fundoo.user.repository.UserRepository;
import com.bridegelabz.fundoo.user.services.UserService;
import com.bridegelabz.fundoo.util.UserToken;
/**
 * Purpose: To Control Request and Responses
 * @author Ahetesham Ahamad
 *
 */
@RestController
public class LoginRestController 
{
	@Autowired
	private UserService userService;
	@Autowired
	UserRepository userrepository;
	@PostMapping("/saveuser")
	public ResponseEntity<Response>  saveUser(@RequestBody UserDto userDto) throws IllegalArgumentException, UnsupportedEncodingException, RegistrationExceptions
	{
		System.out.println("Inside save user");
		Response response = userService.saveMyUser(userDto); 
		System.out.println("Response got");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	@GetMapping("user/{token}")
	public ResponseEntity<Response> emailVerification(@PathVariable String token) throws UnsupportedEncodingException
	{
		 Response response = userService.verification(token);
		 return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	@ResponseBody
	@PostMapping("/login")
	public ResponseEntity<ResponseToken> login(@RequestBody LoginDto loginDto)
	{
		ResponseToken response = userService.loginService(loginDto);
		return new ResponseEntity<ResponseToken>(response, HttpStatus.OK);
				
	}
	@PostMapping("/forgotPassword")
	public ResponseEntity<Response> forgotPassword(@RequestParam String emailId) throws IllegalArgumentException, UnsupportedEncodingException
	{
		Response response = userService.changePasswordMailSender(emailId);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	@PutMapping("/setPassword/{token}")
	public ResponseEntity<Response> setNewPassword(@RequestParam String newPassword, @PathVariable String token) throws UnsupportedEncodingException
	{
		Response response = userService.setNewPasswordService(newPassword,token);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	@PostMapping("/resetPassword")
	public ResponseEntity<Response> resetPassword(@RequestParam String oldEmailId) throws IllegalArgumentException, UnsupportedEncodingException
	{
		Response response = userService.changePasswordMailSender(oldEmailId);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
}
