package com.iitb.courses.repository;

import com.iitb.courses.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Optional<Course> findById(Long id); // ✅ From JpaRepository


    List<Course> findByPrerequisitesContaining(Course prerequisite);

    List<Course> findByPrerequisites_CourseId(Long prerequisiteId);
}
