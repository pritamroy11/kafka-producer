package com.kafka.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.producer.entity.Student;
import com.kafka.producer.request.StudentInput;
import com.kafka.producer.service.KafkaProducerService;

@Controller
public class StudentController {
	
	@Autowired
	ObjectMapper mapper;
	
	@Autowired
	KafkaProducerService service;
	
	@QueryMapping
	public String welcome() {
		return "This is Kafka Producer Service!";
	}
	
	@MutationMapping
	public Student addStudent(@Argument("input") StudentInput input) throws JsonProcessingException {
		Student student = mapper.convertValue(input, Student.class);
		service.sendStudentData(student);
		return student;
	}

}
