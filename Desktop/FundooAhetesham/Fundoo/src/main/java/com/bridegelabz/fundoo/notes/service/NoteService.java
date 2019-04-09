package com.bridegelabz.fundoo.notes.service;

import java.time.LocalDateTime;
import java.util.Optional;

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
	
	public Response createNote(NotesDto noteDto, String token) throws Exception 
	{
		if(noteDto.getTitle().isEmpty() || noteDto.getDescription().isEmpty())
			throw new Exception("User does not exist");
		
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
	public Response updateNote(NotesDto noteDto, String token, int noteId) throws Exception
	{
		if(noteDto.getTitle().isEmpty() && noteDto.getDescription().isEmpty())
			throw new Exception("Title and Description is empty");
		int userId = UserToken.tokenVerify(token);
	    Optional <User> user = userRepositpory.findById(userId); 
	    if(user.isPresent())
	    {
	    	Optional <Notes> notes = noteRepository.findById(noteId);
	    	int existingUserId = notes.get().getUser().getId();
	    	if(userId == existingUserId)
	    	{
	    		notes.get().setCreatedDateAndTime(LocalDateTime.now());
	    		notes.get().setTitle(noteDto.getTitle());
	    		notes.get().setDescription(noteDto.getDescription());
				noteRepository.save(notes.get());
	    	}
	    		
	    }
	    else
	    {
	    	throw new Exception("User does not exist");
	    }
	    return StatusHelper.statusInfo("Note Updated", 30);
	}
	public Response deleteNote(String token, int noteId) throws Exception
	{
		int id = UserToken.tokenVerify(token);
		Optional<User> user = userRepositpory.findById(id);
		if(user.isPresent())
		{
			Optional<Notes> notes = noteRepository.findById(noteId);
			System.out.println(notes.get().isTrash());
			if(notes.get().isTrash())
			{
		    	throw new Exception("Its Alrady deleted");
			}
			else
			{
				notes.get().setTrash(true);
			}
			System.out.println(notes.get().isTrash());
			return StatusHelper.statusInfo("Note deleted", 93);
		}
		else
		{
			throw new Exception("User Does not Exist");
		}
		
	}
	public Response deleteNotePermanently(String token, int noteId) throws Exception 
	{
		int id = UserToken.tokenVerify(token);
		Optional <User> user = userRepositpory.findById(id);
		if(user.isPresent())
		{
			Optional<Notes> notes = noteRepository.findById(noteId);
			if(notes.isPresent())
			{
				if(notes.get().isTrash())
				{
					noteRepository.delete(notes.get());
				}	
				return StatusHelper.statusInfo("Note deleted Permanently", 40);
			}
			else
			{
				throw new Exception("Note Does Not Exist!");
			}
			
		}
		else
		{
			throw new Exception("User Does Not Exist!");
		}
		
	}
	public Response pin(String token, int noteId) throws Exception
	{
		int id = UserToken.tokenVerify(token);
		Optional<User> user = userRepositpory.findById(id);
		if(user.isPresent())
		{
			Optional<Notes> notes = noteRepository.findById(noteId);
			if(notes.get().isPin())
			{
				notes.get().setPin(false);
				notes.get().setModefiedDateTime(LocalDateTime.now());
				noteRepository.save(notes.get());
				return StatusHelper.statusInfo("UnPined", 50);
			}
			else
			{
				notes.get().setPin(true);
				notes.get().setModefiedDateTime(LocalDateTime.now());
				noteRepository.save(notes.get());
				return StatusHelper.statusInfo("Pined", 60);
			}
		}
	else
	{
		throw new Exception("User Doesnt Exist");

	}
  }		
	public Response archive(String token, int noteId) throws Exception
	{
		int id = UserToken.tokenVerify(token);
		Optional<User> user = userRepositpory.findById(id);
		if(user.isPresent())
		{
			Optional<Notes> notes = noteRepository.findById(noteId);
			if(notes.get().isArchive())
			{
				notes.get().setArchive(false);
				notes.get().setModefiedDateTime(LocalDateTime.now());
				noteRepository.save(notes.get());
				return StatusHelper.statusInfo("UnArchived", 70);
			}
			else
			{
				notes.get().setArchive(true);
				notes.get().setModefiedDateTime(LocalDateTime.now());
				noteRepository.save(notes.get());
				return StatusHelper.statusInfo("Archived", 80);
			}
		}
		else
		{
			throw new Exception("User Doesnt Exist");

		}
		
	}
	public Response Trash(String token, int noteId) throws Exception
	{
		int id = UserToken.tokenVerify(token);
		Optional<User> user = userRepositpory.findById(id);
		if(user.isPresent())
		{
			Optional<Notes> notes = noteRepository.findById(noteId);
			if(notes.get().isTrash())
			{
				notes.get().setTrash(false);
				notes.get().setModefiedDateTime(LocalDateTime.now());
				noteRepository.save(notes.get());
				return StatusHelper.statusInfo("UnTrashed", 90);
			}
			else
			{
				notes.get().setTrash(true);
				notes.get().setModefiedDateTime(LocalDateTime.now());
				noteRepository.save(notes.get());
				return StatusHelper.statusInfo("Trashed", 91);
			}
		}
		else
		{
			throw new Exception("User Doesnt Exist");

		}
	}
}
	
	

