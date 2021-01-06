package com.courseapi.services;

import com.courseapi.models.Course;
import com.courseapi.repository.CourseRepository;
import com.courseapi.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(long topicId) {
        return courseRepository.findByTopicId(topicId);
    }

    public Course getCourseByName(String name) {
        return courseRepository.findCourseByName(name);
    }

    public Course getCourseById(long id) {
        return courseRepository.getOne(id);
    }

    public List<Course> addCourse(Course course, long topicId) {
        courseRepository.save(course);
        return getAllCourses(topicId);
    }

    public Course updateCourse(long id, Course course) {
        courseRepository.save(course);
        return getCourseById(id);
    }

    public List<Course> deleteCourse(long topicId, long id) {
        courseRepository.delete(getCourseById(id));
        return getAllCourses(topicId);
    }
}
