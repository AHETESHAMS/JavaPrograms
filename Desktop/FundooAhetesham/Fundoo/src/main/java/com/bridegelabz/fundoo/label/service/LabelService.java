package com.bridegelabz.fundoo.label.service;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.Optional;

import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.bridegelabz.fundoo.exception.CreateLabelExceptions;
import com.bridegelabz.fundoo.label.dto.LabelDto;
import com.bridegelabz.fundoo.label.model.Label;
import com.bridegelabz.fundoo.label.repository.LabelRepository;
import com.bridegelabz.fundoo.response.Response;
import com.bridegelabz.fundoo.user.repository.UserRepository;
import com.bridegelabz.fundoo.util.StatusHelper;
import com.bridegelabz.fundoo.util.UserToken;
@Service
public class LabelService 
{
	@Autowired
	Environment environment;
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	UserRepository userRepository;
	@Autowired
	LabelRepository labelRepository;
	public Response createLabel(LabelDto labelDto,  String token) throws UnsupportedEncodingException
	{
		if(labelDto.getName().isEmpty())
			throw new CreateLabelExceptions(environment.getProperty("status.label.labelEmpty"),Integer.parseInt(environment.getProperty("status.label.failure")));
		Label label =  modelMapper.map(labelDto, Label.class);
		int id = UserToken.tokenVerify(token);
		Optional<com.bridegelabz.fundoo.user.model.User> user = userRepository.findById(id);
		if(user.isPresent())
		{
			label.setUser(user.get());
			label.setCreateDate(LocalDateTime.now());
			labelRepository.save(label);
			return StatusHelper.statusInfo(environment.getProperty("status.label.labelCreated"), Integer.parseInt(environment.getProperty("status.label.success")));
		}
		else
		{
			throw new CreateLabelExceptions(environment.getProperty("status.label.userNotExist "), Integer.parseInt(environment.getProperty("status.label.failure")));
		}
		
	}
	public Response updateLabel(LabelDto labelDto, String token, int labelId) throws UnsupportedEncodingException 
	{
		if(labelDto.getName().isEmpty())
			throw new CreateLabelExceptions(environment.getProperty("status.label.labelEmpty"), Integer.parseInt(environment.getProperty("status.label.failure")));
		int userId = UserToken.tokenVerify(token);
		Optional<com.bridegelabz.fundoo.user.model.User> user = userRepository.findById(userId);
		if(user.isPresent())
		{
			Optional<Label> label = labelRepository.findById(labelId);
			if(label.isPresent())
			{	
				int existingUserId = label.get().getUser().getId();
				if(existingUserId == userId)
				{
					label.get().setName(labelDto.getName());
					label.get().setModifiedDate(LocalDateTime.now());
					labelRepository.save(label.get());
				}
			}
			else
				throw new CreateLabelExceptions(environment.getProperty("status.label.labelNotExist"), Integer.parseInt(environment.getProperty("status.label.failure")));
		}
		else
		{
			throw new CreateLabelExceptions(environment.getProperty("status.label.userNotExist"), Integer.parseInt(environment.getProperty("status.label.failure")));
		}
		return StatusHelper.statusInfo(environment.getProperty("status.label.labelUpdated"), Integer.parseInt(environment.getProperty("status.label.success")));
	}
	public Response deleteLabel(String token, int labelId) throws UnsupportedEncodingException
	{
		int userId = UserToken.tokenVerify(token);
		Optional<com.bridegelabz.fundoo.user.model.User> user = userRepository.findById(userId);
		if(user.isPresent())
		{
			Optional<Label> label = labelRepository.findById(labelId);
			if(label.isPresent())
			{
				labelRepository.delete(label.get());
			}
			else
			{
				throw new CreateLabelExceptions(environment.getProperty("status.label.labelNotExist"), Integer.parseInt(environment.getProperty("status.label.failure")));
			}
		}
		else
		{
			throw new CreateLabelExceptions(environment.getProperty("status.label.userNotExist"), Integer.parseInt(environment.getProperty("status.label.failure")));
		}
		
		return StatusHelper.statusInfo(environment.getProperty("status.label.deleted"), Integer.parseInt(environment.getProperty("status.label.success")));
	}

}
