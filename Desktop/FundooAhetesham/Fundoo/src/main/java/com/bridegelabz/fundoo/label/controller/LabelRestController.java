package com.bridegelabz.fundoo.label.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridegelabz.fundoo.label.dto.LabelDto;
import com.bridegelabz.fundoo.label.model.Label;
import com.bridegelabz.fundoo.label.repository.LabelRepository;
import com.bridegelabz.fundoo.label.service.LabelService;
import com.bridegelabz.fundoo.response.Response;
import com.bridegelabz.fundoo.user.services.UserService;

@RestController
public class LabelRestController 
{
	@Autowired
	LabelService labelService;
	@PostMapping("/createlabel")
	public ResponseEntity<Response> createLabel(@RequestBody LabelDto labelDto, @RequestParam String token, @RequestParam int noteId) throws UnsupportedEncodingException
	{
		Response response = labelService.createLabel(labelDto, token);
		return new ResponseEntity<Response>(response,HttpStatus.OK);
	}
	@PutMapping("/updatelabel")
	public ResponseEntity<Response> updateLabel(@RequestBody LabelDto labelDto, @RequestParam String token, @RequestParam int labelId) throws UnsupportedEncodingException
	{
		Response response = labelService.updateLabel(labelDto, token, labelId);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
		
	}
	@PutMapping("/deletelabel")
	public ResponseEntity<Response> deleteLabel(@RequestParam String token, @RequestParam int labelId) throws UnsupportedEncodingException
	{
		Response response = labelService.deleteLabel(token, labelId);
		return new ResponseEntity<Response>(response,HttpStatus.OK);
		
	}
	@PostMapping("/addlabeltonote")
	public ResponseEntity<Response> addLabelToNote(@RequestBody LabelDto labelDto, @RequestParam String token, @RequestParam int noteId) throws UnsupportedEncodingException
	{
		Response response = labelService.addLabelToNote(labelDto, token, noteId);
		return new ResponseEntity<Response> (response, HttpStatus.OK);
		
	}
	
}
