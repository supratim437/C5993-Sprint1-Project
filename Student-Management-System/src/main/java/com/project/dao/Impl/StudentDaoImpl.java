package com.project.dao.Impl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.dao.StudentDao;
import com.project.demo.entity.Courses;
import com.project.demo.entity.Student;
import com.project.demo.userexception.CourseException;
import com.project.demo.userexception.StudentException;
import com.project.demo.utils.Hibernate_Util;

public class StudentDaoImpl implements StudentDao {

	@Override
	public void saveStudent(Student student, Integer c_Id) {
		Session session = Hibernate_Util.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			Courses courses = session.get(Courses.class, c_Id);
			student.setCourses(courses);
			session.save(student);

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new StudentException("ERROR PLEASE CHEAK.... " + e.getMessage(), e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateStudent(Student student, Integer c1_Id) {
		Session session = Hibernate_Util.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Courses courses = session.get(Courses.class, c1_Id);
			student.setCourses(courses);
			session.merge(student);

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new StudentException("ERROR PLEASE CHEAK.... " + e.getMessage(), e);
		} finally {
			session.close();
		}
	}

	@Override
	public Student getStudentById(Integer id) {
		Session session = Hibernate_Util.getSessionFactory().openSession();
		Transaction tx = null;
		Student student = null;
		try {
			tx = session.beginTransaction();

			student = session.get(Student.class, id);

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new StudentException("ERROR PLEASE CHEAK.... " + e.getMessage(), e);
		} finally {
			session.close();
		}
		return student;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Student> getAllStudents() {
		Session session = Hibernate_Util.getSessionFactory().openSession();
		Transaction tx = null;
		List<Student> students = null;
		try {
			tx = session.beginTransaction();

			students = session.createQuery("from Student").list();

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return students;
	}

	@Override
	public Student deleteStudentById(Integer id) {
		Session session = Hibernate_Util.getSessionFactory().openSession();
		Transaction tx = null;
		Student student = null;
		try {
			tx = session.beginTransaction();

			student = session.get(Student.class, id);

			session.delete(student);

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new StudentException("ERROR PLEASE CHEAK.... " + e.getMessage(), e);
		} finally {
			session.close();
		}
		return student;
	}
}