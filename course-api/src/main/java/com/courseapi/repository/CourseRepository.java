package com.courseapi.repository;

import com.courseapi.models.Course;
import com.courseapi.models.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findCourseByName(String name);
    List<Course> findByTopicId(long topicId);
}
