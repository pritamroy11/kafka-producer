package com.kafka.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.producer.entity.Student;

@Service
public class KafkaProducerService {
	
	@Autowired
	KafkaTemplate<String, String> template;
	
	@Autowired
	ObjectMapper mapper;
	
	public void sendStudentData(Student student) throws JsonProcessingException {
		template.sendDefault(student.getId(), mapper.writeValueAsString(student));
	}

}
