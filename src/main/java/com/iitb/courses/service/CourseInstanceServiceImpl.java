package com.iitb.courses.service;

import com.iitb.courses.model.Course;
import com.iitb.courses.model.CourseInstance;
import com.iitb.courses.repository.CourseInstanceRepository;
import com.iitb.courses.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseInstanceServiceImpl implements CourseInstanceService {

    @Autowired
    private CourseInstanceRepository instanceRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public CourseInstance createInstance(CourseInstance instance, String courseId) {
        Course course = courseRepository.findById(Long.parseLong(courseId))
                .orElseThrow(() -> new IllegalArgumentException("Course not found: " + courseId));

        instance.setCourse(course);
        return instanceRepository.save(instance);
    }

    @Override
    public List<CourseInstance> getInstancesByYearAndSemester(int year, int semester) {
        return instanceRepository.findByYearAndSemester(year, semester);
    }

    @Override
    public CourseInstance getInstanceByCourseAndTime(int year, int semester, String courseId) {
        Course course = courseRepository.findById(Long.parseLong(courseId))
                .orElseThrow(() -> new IllegalArgumentException("Course not found: " + courseId));

        return instanceRepository.findByYearAndSemesterAndCourse(year, semester, course)
                .orElseThrow(() -> new IllegalArgumentException("Instance not found"));
    }

    @Override
    public void deleteInstance(int year, int semester, String courseId) {
        Course course = courseRepository.findById(Long.parseLong(courseId))
                .orElseThrow(() -> new IllegalArgumentException("Course not found: " + courseId));

        instanceRepository.deleteByYearAndSemesterAndCourse(year, semester, course);
    }
}
