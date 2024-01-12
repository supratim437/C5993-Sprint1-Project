package com.project.dao;

import java.util.List;

import com.project.demo.entity.Teacher;

public interface TeacherDao {

	void saveTeacher(Teacher teacher, Integer c2_Id);

	void updateTeacher(Teacher teacher, Integer c3_Id);

	Teacher getTeacherById(Integer id);

	List<Teacher> getAllTeachers();

	Teacher deleteTeacherById(Integer id);

}