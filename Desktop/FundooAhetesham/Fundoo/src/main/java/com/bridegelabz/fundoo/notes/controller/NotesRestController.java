package com.bridegelabz.fundoo.notes.controller;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridegelabz.fundoo.notes.dto.NotesDto;
import com.bridegelabz.fundoo.notes.model.Notes;
import com.bridegelabz.fundoo.notes.repository.NoteRepository;
import com.bridegelabz.fundoo.notes.service.NoteService;
import com.bridegelabz.fundoo.response.Response;
import com.bridegelabz.fundoo.user.model.User;
import com.bridegelabz.fundoo.user.repository.UserRepository;

@RestController
public class NotesRestController 
{
	@Autowired
	private NoteService noteService;
	@PostMapping("/createnote")
	public ResponseEntity<Response> crateNotes(@RequestBody NotesDto noteDto , @RequestParam String token) throws UnsupportedEncodingException
	{
		Response response = noteService.createNote(noteDto, token);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
}
