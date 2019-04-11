package com.bridegelabz.fundoo.user.services;
import com.bridegelabz.fundoo.util.*;

import ch.qos.logback.classic.pattern.Util;
import ch.qos.logback.core.encoder.Encoder;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.Optional;

import javax.security.auth.login.LoginException;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bridegelabz.fundoo.exception.LoginExceptions;
import com.bridegelabz.fundoo.exception.RegistrationExceptions;
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
@PropertySource("classpath:message.properties")
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
	@Autowired
	private Environment environment;
	/**
	 * purpose: To Register and save user
	 * @throws RegistrationExceptions 
	 * @throws UnsupportedEncodingException 
	 * @throws IllegalArgumentException 
	 */
	public Response saveMyUser(UserDto userDto) throws RegistrationExceptions, IllegalArgumentException, UnsupportedEncodingException
	{
		System.out.println("Inside save my user fun");
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));  
		User user = modelMapper.map(userDto, User.class);
		Optional<User> userExist = userRepository.findByEmailId(user.getEmailId());
		if(userExist.isPresent())
		{
			System.out.println("User alrady Exist");
			throw new RegistrationExceptions(environment.getProperty("status.register.userAlreadyExist"), Integer.parseInt(environment.getProperty("status.token.ErrorCode")));
		}
		else
		{
			System.out.println("Inside else to save");
			user.setRegisteredDate(LocalDate.now());
			userRepository.save(user);
			System.out.println("User saved");
			String to=user.getEmailId();
			String sub="Verification";
			String url="http://localhost:8080/user/"+UserToken.generateToken(user.getId());
			emailService.sendMail(to,sub,url);
			System.out.println("Mail sent");
			return StatusHelper.statusInfo(environment.getProperty("status.mail.mailSent"), Integer.parseInt(environment.getProperty("status.mail.mailSentCode")));
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
		System.out.println("User : "+ user.get().toString());
		user.get().setVerified(true);
		user.get().setModifiedDate(LocalDate.now());
		System.out.println("User : "+ user.get().toString());
		userRepository.save(user.get());
		return StatusHelper.statusInfo(environment.getProperty("status.register.successRegistered"), Integer.parseInt(environment.getProperty("status.register.successCode")));
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
			return StatusHelper.statusInfo(environment.getProperty("status.mail.mailSent"), Integer.parseInt(environment.getProperty("status.mail.mailSentCode")));
		}
		else
		{
			throw new RegistrationExceptions(environment.getProperty("status.userNotExist"), Integer.parseInt(environment.getProperty("status.token.ErrorCode")));
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
			return response = StatusHelper.statusInfo(environment.getProperty("status.setPassword"), Integer.parseInt(environment.getProperty("status.register.successCode")));//New Password Set
		}
		else
		{
			throw new RegistrationExceptions(environment.getProperty("status.userNotExist"), Integer.parseInt(environment.getProperty("status.token.ErrorCode")));
		}
	}
	/**
	 * Purpose: To check whether user is present or not and make him logged in
	 */
	public ResponseToken loginService(LoginDto loginDto)
	{
		String token=null;
		Optional<User> user = userRepository.findByEmailId(loginDto.getEmailId());
		int id = user.get().getId();
		if(user.isPresent())
		{
			if(passwordEncoder.matches(loginDto.getPassword(), user.get().getPassword()))
			{
				try {
					token = UserToken.generateToken(id);
				} catch (IllegalArgumentException | UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return StatusHelper.tokenStatusinfo(environment.getProperty("status.login.success"), Integer.parseInt(environment.getProperty("status.login.successCode")), token);
			}
			else
			{
				throw new LoginExceptions(environment.getProperty("status.login.falure"), token, Integer.parseInt(environment.getProperty("status.login.falureCode")));
			}
		}
		else
		{
			return StatusHelper.tokenStatusinfo(environment.getProperty("status.userNotExist"),Integer.parseInt(environment.getProperty("status.login.falureCode")),token);
		}
	}
	
	
}
