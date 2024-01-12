package com.project.dao;

import java.util.List;

import com.project.demo.entity.Student;

public interface StudentDao {

	void saveStudent(Student student,Integer c_Id);

	void updateStudent(Student student,Integer c1_Id);

	Student getStudentById(Integer id);

	List<Student> getAllStudents();

	Student deleteStudentById(Integer id);

}