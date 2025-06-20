// CourseService.java
package com.iitb.courses.service;

import com.iitb.courses.model.Course;
import java.util.List;

public interface CourseService {
    Course createCourse(Course course);
    List<Course> getAllCourses();
    Course getCourseById(Long id);
    void deleteCourse(Long id);
}
