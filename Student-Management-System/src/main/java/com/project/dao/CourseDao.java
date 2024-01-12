package com.project.dao;

import java.util.List;

import com.project.demo.entity.Courses;

public interface CourseDao {

	void saveCourse(Courses courses);

	void updateCourse(Courses courses);

	Courses getCourseById(Integer id);

	List<Courses> getAllCourse();

	Courses deleteCourseById(Integer id);

}