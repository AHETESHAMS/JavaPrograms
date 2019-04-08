package com.bridegelabz.fundoo.notes.service;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.Optional;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridegelabz.fundoo.notes.dto.NotesDto;
import com.bridegelabz.fundoo.notes.model.Notes;
import com.bridegelabz.fundoo.notes.repository.NoteRepository;
import com.bridegelabz.fundoo.response.Response;
import com.bridegelabz.fundoo.user.model.User;
import com.bridegelabz.fundoo.user.repository.UserRepository;
import com.bridegelabz.fundoo.util.StatusHelper;
import com.bridegelabz.fundoo.util.UserToken;
@Service
public class NoteService 
{
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private NoteRepository noteRepository;
	@Autowired
	private UserRepository userRepositpory;
	
	public Response createNote(NotesDto noteDto, String token) throws UnsupportedEncodingException 
	{
		if(noteDto.getTitle()!=null || noteDto.getDescription()!=null)
		{
			Notes notes = modelMapper.map(noteDto, Notes.class);
			int id = UserToken.tokenVerify(token);
			Optional<User> user = userRepositpory.findById(id);
			if(user.isPresent())
			{
				notes.setUser(user.get());
				notes.setCreatedDateAndTime(LocalDateTime.now());
				noteRepository.save(notes);
				return StatusHelper.statusInfo("Note Created", 10);
			}	
			else
			{
				return StatusHelper.statusInfo("User not available", 20);
			}
		}
		else
		{
			return StatusHelper.statusInfo("Please enter at least one parameter!", 30);
		}
		
	}
	
	
}
