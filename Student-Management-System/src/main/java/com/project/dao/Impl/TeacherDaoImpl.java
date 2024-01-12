package com.project.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.dao.TeacherDao;
import com.project.demo.entity.Courses;
import com.project.demo.entity.Teacher;
import com.project.demo.userexception.StudentException;
import com.project.demo.userexception.TeacherException;
import com.project.demo.utils.Hibernate_Util;

public class TeacherDaoImpl implements TeacherDao {

	@Override
	public void saveTeacher(Teacher teacher, Integer c2_Id) {
		Session session = Hibernate_Util.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			Courses courses = session.get(Courses.class, c2_Id);
			teacher.setCourses(courses);
			session.save(teacher);

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new TeacherException("ERROR PLEASE CHEAK.... " + e.getMessage(), e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateTeacher(Teacher teacher, Integer c3_Id) {
		Session session = Hibernate_Util.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Courses courses = session.get(Courses.class, c3_Id);
			teacher.setCourses(courses);
			session.merge(teacher);

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new TeacherException("ERROR PLEASE CHEAK.... " + e.getMessage(), e);
		} finally {
			session.close();
		}
	}

	@Override
	public Teacher getTeacherById(Integer id) {
		Session session = Hibernate_Util.getSessionFactory().openSession();
		Transaction tx = null;
		Teacher teacher = null;
		try {
			tx = session.beginTransaction();

			teacher = session.get(Teacher.class, id);

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new TeacherException("ERROR PLEASE CHEAK.... " + e.getMessage(), e);
		} finally {
			session.close();
		}
		return teacher;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Teacher> getAllTeachers() {
		Session session = Hibernate_Util.getSessionFactory().openSession();
		Transaction tx = null;
		List<Teacher> teachers = null;
		try {
			tx = session.beginTransaction();

			teachers = session.createQuery("from Teacher").list();

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return teachers;
	}

	@Override
	public Teacher deleteTeacherById(Integer id) {
		Session session = Hibernate_Util.getSessionFactory().openSession();
		Transaction tx = null;
		Teacher teacher = null;
		try {
			tx = session.beginTransaction();

			teacher = session.get(Teacher.class, id);

			session.delete(teacher);

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new TeacherException("ERROR PLEASE CHEAK.... " + e.getMessage(), e);
		} finally {
			session.close();
		}
		return teacher;
	}
}