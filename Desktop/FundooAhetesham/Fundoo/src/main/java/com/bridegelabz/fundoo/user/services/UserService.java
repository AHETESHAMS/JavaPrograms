package com.bridegelabz.fundoo.user.services;
import com.bridegelabz.fundoo.util.*;

import ch.qos.logback.classic.pattern.Util;
import ch.qos.logback.core.encoder.Encoder;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bridegelabz.fundoo.response.Response;
import com.bridegelabz.fundoo.response.ResponseToken;
import com.bridegelabz.fundoo.user.dto.LoginDto;
import com.bridegelabz.fundoo.user.dto.UserDto;
import com.bridegelabz.fundoo.user.model.User;
import com.bridegelabz.fundoo.user.repository.UserRepository;
/**
 * Purpose: To Provide Service to the Rest Controller
 * @author Ahetesham Ahamad
 *
 */
@Service
@Transactional
public class UserService implements IUserService
{
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private EmailService emailService;
	@Autowired
	private  UserRepository userRepository;
	@Autowired
	private Response response = null;
	@Autowired
	private ResponseToken responseToken = null;
	/**
	 * purpose: To Register and save user
	 */
	public Response saveMyUser(UserDto userDto) throws IllegalArgumentException, UnsupportedEncodingException
	{
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));  
		User user = modelMapper.map(userDto, User.class);
		Optional<User> userExist = userRepository.findByEmailId(user.getEmailId());
		if(userExist.isPresent())
		{
			System.out.println("User alrady Exist");
			return StatusHelper.statusInfo("User Alrady Exist", 200);
		}
		else
		{
			user.setRegisteredDate(LocalDate.now());
			userRepository.save(user);
			String to=user.getEmailId();
			String sub="Verification";
			String url="http://localhost:8080/user/"+UserToken.generateToken(user.getId());
			emailService.sendMail(to,sub,url);
			return StatusHelper.statusInfo("Email Sent", 100);
		}	
	}
	/**
	 * Purpose: To verify user using email
	 */
	public Response verification(String token) throws UnsupportedEncodingException 
	{
		int id = UserToken.tokenVerify(token);
		System.out.println("id:"+id);
		Optional<User> user = userRepository.findById(id);
		user.get().setVerified(true);
		user.get().setModifiedDate(LocalDate.now());
		userRepository.save(user.get());
		return response = StatusHelper.statusInfo("User Saved", 100);
	}
	/**
	 * Purpose: To Change the password of of Exiting User 
	 */
	public Response changePasswordMailSender(String emailId) throws IllegalArgumentException, UnsupportedEncodingException 
	{
		String to = emailId;
		String subject = "Change Password";
		Optional<User> user = userRepository.findByEmailId(emailId);
		if(user.isPresent())
		{
			String url = "http://localhost:8080/setPassword/"+UserToken.generateToken(user.get().getId());
			emailService.sendMail(to, subject, url);
			return response = StatusHelper.statusInfo("Email Sent", 600);
		}
		else
		{
			return response = StatusHelper.statusInfo("User does not Exist", 700);
		}
		
	}
	/**
	 * Purpose: To Set the the new Password of Existing User
	 */
	public Response setNewPasswordService(String newPassword, String token) throws UnsupportedEncodingException 
	{
		int id = UserToken.tokenVerify(token);
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent())
		{
			user.get().setPassword(passwordEncoder.encode(newPassword));
			userRepository.save(user.get());	
			return response = StatusHelper.statusInfo("New Password Set", 800);
		}
		else
		{
			return response = StatusHelper.statusInfo("User Does not Exist", 900);
		}
	}
	/**
	 * Purpose: To check whether user is present or not and make him logged in
	 */
	public ResponseToken loginService(LoginDto loginDto)
	{
		Optional<User> user = userRepository.findByEmailId(loginDto.getEmailId());
		int id = user.get().getId();
		if(user.isPresent())
		{
			if(passwordEncoder.matches(loginDto.getPassword(), user.get().getPassword()))
			{
				String token=null;
				try {
					token = UserToken.generateToken(id);
				} catch (IllegalArgumentException | UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return StatusHelper.tokenStatusinfo("Login Successful", 300, token);
			}
			else
			{
				return StatusHelper.tokenStatusinfo("Invalid Password", 400, null);
			}
		}
		else
		{
			return StatusHelper.tokenStatusinfo("User is not present", 300, null);
		}
	}
	
	
}
