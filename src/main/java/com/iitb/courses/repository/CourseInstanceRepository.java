package com.iitb.courses.repository;

import com.iitb.courses.model.CourseInstance;
import com.iitb.courses.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseInstanceRepository extends JpaRepository<CourseInstance, Long> {
    List<CourseInstance> findByYearAndSemester(int year, int semester);
    Optional<CourseInstance> findByYearAndSemesterAndCourse(int year, int semester, Course course);
    void deleteByYearAndSemesterAndCourse(int year, int semester, Course course);
}
