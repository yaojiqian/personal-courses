package com.bitcode.personalcourses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PersonalCoursesApplication {

	static Logger log = LoggerFactory.getLogger(PersonalCoursesApplication.class);
	
	public static void main(String[] args) {
		log.info("lll");
		SpringApplication.run(PersonalCoursesApplication.class, args);
	}

}
