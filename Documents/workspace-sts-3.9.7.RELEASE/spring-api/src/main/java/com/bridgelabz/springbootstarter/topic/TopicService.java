package com.bridgelabz.springbootstarter.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	public List<Topic> topics = Arrays.asList(
			return Arrays.asList(
					new Topic("101","spring","Spring Framework"),
					new Topic("102","java","core java"),
					new Topic("103","jS","JavaScript")
			);
}
