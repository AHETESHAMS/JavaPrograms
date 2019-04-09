package com.bridegelabz.fundoo.notes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridegelabz.fundoo.notes.dto.NotesDto;
import com.bridegelabz.fundoo.notes.service.NoteService;
import com.bridegelabz.fundoo.response.Response;

@RestController
public class NotesRestController 
{
	@Autowired
	private NoteService noteService;
	@PostMapping("/createnote")
	public ResponseEntity<Response> crateNotes(@RequestBody NotesDto noteDto , @RequestParam String token) throws Exception
	{
		Response response = noteService.createNote(noteDto, token);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	@PutMapping("/updatenote")
	public ResponseEntity<Response> updateNotes(@RequestBody NotesDto noteDto, @RequestParam String token, @RequestParam int noteId) throws Exception
	{
		Response response = noteService.updateNote(noteDto, token, noteId);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
		
	}
	@PutMapping("/deletenote")
	public ResponseEntity<Response> deleteNote(@RequestParam String token, @RequestParam int noteId) throws Exception
	{
		Response response = noteService.deleteNote(token, noteId);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
		
	}
	@PutMapping("/deletenotepermanently")
	public ResponseEntity<Response> deleteNotePermanently(@RequestParam String token, @RequestParam int noteId) throws Exception
	{
		Response response = noteService.deleteNotePermanently(token, noteId);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
		
	}
	@PutMapping("/pin")
	public ResponseEntity<Response> pin(@RequestParam String token, @RequestParam int noteId) throws Exception
	{
		Response response = noteService.pin(token, noteId);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	@PutMapping("/archive")
	public ResponseEntity<Response> archive(@RequestParam String token, @RequestParam int noteId) throws Exception
	{
		Response response = noteService.archive(token, noteId);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	@PutMapping("/trash")
	public ResponseEntity<Response> trash(@RequestParam String token, @RequestParam int noteId) throws Exception
	{
		Response response = noteService.Trash(token, noteId);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
}
