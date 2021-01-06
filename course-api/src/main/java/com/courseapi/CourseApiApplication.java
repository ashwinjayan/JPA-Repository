package com.courseapi;

import com.courseapi.models.Course;
import com.courseapi.models.Topic;
import com.courseapi.repository.CourseRepository;
import com.courseapi.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CourseApiApplication implements CommandLineRunner {

	@Autowired
	private TopicRepository topicRepository;

	@Autowired
	private CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(CourseApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Topic java = new Topic(1, "Java", "Java Developement Courses");
		List<Topic> topicList = new ArrayList<Topic>();
		topicList.add(java);
		topicList.add(new Topic(2, "JavaScript", "Javascript Courses"));
		topicList.add(new Topic(3, "Python", "Python Courses"));

		topicRepository.saveAll(topicList);

		Course course = new Course(1, "Java Streams", "Stream API in JAVA", java);
		courseRepository.save(course);
	}
}
