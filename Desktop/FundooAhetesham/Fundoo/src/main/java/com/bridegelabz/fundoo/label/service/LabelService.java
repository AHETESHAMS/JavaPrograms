package com.bridegelabz.fundoo.label.service;

import java.io.UnsupportedEncodingException;

import java.time.LocalDateTime;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import com.bridegelabz.fundoo.exception.CreateLabelExceptions;
import com.bridegelabz.fundoo.label.dto.LabelDto;
import com.bridegelabz.fundoo.label.model.Label;
import com.bridegelabz.fundoo.label.repository.LabelRepository;
import com.bridegelabz.fundoo.notes.model.Notes;
import com.bridegelabz.fundoo.notes.repository.NoteRepository;
import com.bridegelabz.fundoo.response.Response;
import com.bridegelabz.fundoo.user.model.User;
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
	@Autowired
	NoteRepository noteRepository;
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
	public Response addLabelToNote(LabelDto labelDto, String token, int noteId) throws UnsupportedEncodingException 
	{
		int userId = UserToken.tokenVerify(token);
		Optional<User> user = userRepository.findById(userId);
		System.out.println(user.toString());
		if(user.isPresent())
		{
			System.out.println(userId);
			Optional<Notes> note = noteRepository.findById(noteId);
			System.out.println(note.isPresent());
			System.out.println(noteId);
			System.out.println(note.get());
			
			if(note.isPresent())
			{
		 
				Optional<Label> labelExist = labelRepository.findByname(labelDto.getName());
				if(labelExist.isPresent())
				{
			
					note.get().getLabel().add(labelExist.get());
					noteRepository.save(note.get());
					return StatusHelper.statusInfo(environment.getProperty("status.label.labelAddedToNote "), Integer.parseInt(environment.getProperty("status.label.success")));
				}
				else
				{
					Label label = modelMapper.map(labelDto, Label.class);
					label.setUser(user.get());
					label.setCreateDate(LocalDateTime.now());
					note.get().getLabel().add(label);
					noteRepository.save(note.get());
					return StatusHelper.statusInfo(environment.getProperty("status.label.labelAddedToNote "), Integer.parseInt(environment.getProperty("status.label.success")));
				}
				
			}
			else
			{ 
				throw new  CreateLabelExceptions(environment.getProperty("status.label.noteNotExist"), Integer.parseInt(environment.getProperty("status.label.failure")));
			}
		}
		else
		{
			throw new CreateLabelExceptions(environment.getProperty("status.label.userNotExist"), Integer.parseInt(environment.getProperty("status.label.failure")));
		}
	}
	public Response removeLabelFromNote(String token, int noteId, int labelId) throws UnsupportedEncodingException
	{
		int userId = UserToken.tokenVerify(token);
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent())
		{
			Optional<Notes> note = noteRepository.findById(noteId);
			if(note.isPresent())
			{
				Optional<Label> label = labelRepository.findById(labelId);
				note.get().getLabel().remove(label.get());
				noteRepository.save(note.get());
				return StatusHelper.statusInfo(environment.getProperty("status.label.labelRemovedFromNote"), Integer.parseInt(environment.getProperty("status.label.success")));
			}
			else 
			{
				throw new  CreateLabelExceptions(environment.getProperty("status.label.noteNotExist"), Integer.parseInt(environment.getProperty("status.label.failure")));
			}
		}
		else
		{
			throw new CreateLabelExceptions(environment.getProperty("status.label.userNotExist"), Integer.parseInt(environment.getProperty("status.label.failure")));
		}
		
	}

}
