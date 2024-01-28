package com.kafka.producer.request;

import lombok.Data;

@Data
public class StudentInput {
	private String id;
	private String name;
	private double marks;
}
