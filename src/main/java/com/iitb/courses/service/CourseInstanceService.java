package com.iitb.courses.service;

import com.iitb.courses.model.CourseInstance;

import java.util.List;

public interface CourseInstanceService {
    CourseInstance createInstance(CourseInstance instance, String courseId);
    List<CourseInstance> getInstancesByYearAndSemester(int year, int semester);
    CourseInstance getInstanceByCourseAndTime(int year, int semester, String courseId);
    void deleteInstance(int year, int semester, String courseId);
}
