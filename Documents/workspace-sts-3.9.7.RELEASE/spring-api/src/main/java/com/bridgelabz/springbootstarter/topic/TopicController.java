package com.bridgelabz.springbootstarter.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics(){
		return Arrays.asList(
				new Topic("101","spring","Spring Framework"),
				new Topic("102","java","core java"),
				new Topic("103","jS","JavaScript")
		);
	}
}
