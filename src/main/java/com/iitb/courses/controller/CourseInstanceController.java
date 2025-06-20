package com.iitb.courses.controller;

import com.iitb.courses.model.CourseInstance;
import com.iitb.courses.service.CourseInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course-instances")
public class CourseInstanceController {

    @Autowired
    private CourseInstanceService courseInstanceService;

    @PostMapping("/{courseId}")
    public ResponseEntity<CourseInstance> createInstance(@RequestBody CourseInstance instance, @PathVariable String courseId) {
        CourseInstance created = courseInstanceService.createInstance(instance, courseId);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<CourseInstance>> getInstances(@RequestParam int year, @RequestParam int semester) {
        return ResponseEntity.ok(courseInstanceService.getInstancesByYearAndSemester(year, semester));
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<CourseInstance> getInstance(@RequestParam int year, @RequestParam int semester, @PathVariable String courseId) {
        return ResponseEntity.ok(courseInstanceService.getInstanceByCourseAndTime(year, semester, courseId));
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> deleteInstance(@RequestParam int year, @RequestParam int semester, @PathVariable String courseId) {
        courseInstanceService.deleteInstance(year, semester, courseId);
        return ResponseEntity.noContent().build();
    }
}
