package com.courseapi.controllers;

import com.courseapi.models.Course;
import com.courseapi.models.Topic;
import com.courseapi.services.CourseService;
import com.courseapi.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics/{topicId}/courses")
    public List<Course> getAllCourses(@PathVariable long topicId) {
        return courseService.getAllCourses(topicId);
    }

    @RequestMapping("/topics/{topicId}/courses/{name}")
    public Course getCourseByName(@PathVariable String name) {
        return courseService.getCourseByName(name);
    }

    @RequestMapping(value = "/topics/{topicId}/courses", method = RequestMethod.POST)
    public List<Course> addCourse(@RequestBody Course course, @PathVariable long topicId) {
        course.setTopic(topicService.getTopicById(topicId));
        return courseService.addCourse(course, topicId);
    }

    @RequestMapping(value = "/topics/{topicId}/courses/{id}", method = RequestMethod.PUT)
    public Course updateCourse(@RequestBody Course course, @PathVariable long topicId, @PathVariable long id) {
        course.setTopic(topicService.getTopicById(topicId));
        return courseService.updateCourse(id, course);
    }

    @RequestMapping(value = "/topics/{topicId}/courses/{id}", method = RequestMethod.DELETE)
    public List<Course> deleteCourse(@PathVariable long topicId, @PathVariable long id) {
        return courseService.deleteCourse(topicId, id);
    }
}
