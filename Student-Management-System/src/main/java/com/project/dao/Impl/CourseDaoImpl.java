package com.project.dao.Impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.dao.CourseDao;
import com.project.demo.entity.Courses;
import com.project.demo.entity.Student;
import com.project.demo.userexception.CourseException;
import com.project.demo.utils.Hibernate_Util;

public class CourseDaoImpl implements CourseDao {

	@Override
	public void saveCourse(Courses courses) {
		Session session = Hibernate_Util.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			session.save(courses);

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new CourseException("ERROR PLEASE CHEAK.... " + e.getMessage(), e);
		}

	}

	@Override
	public void updateCourse(Courses courses) {
		Session session = Hibernate_Util.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			session.merge(courses);

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new CourseException("ERROR PLEASE CHEAK.... " + e.getMessage(), e);
		}

	}

	@Override
	public Courses getCourseById(Integer id) {
		Session session = Hibernate_Util.getSessionFactory().openSession();
		Transaction tx = null;
		Courses courses = null;
		try {
			tx = session.beginTransaction();

			courses = session.get(Courses.class, id);

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new CourseException("ERROR PLEASE CHEAK.... " + e.getMessage(), e);
		}
		return courses;

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Courses> getAllCourse() {
		Session session = Hibernate_Util.getSessionFactory().openSession();

		List<Courses> courses = null;
		try {

			courses = session.createQuery("from Courses").list();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return courses;

	}

	@Override
	public Courses deleteCourseById(Integer id) {
		Session session = Hibernate_Util.getSessionFactory().openSession();
		Transaction tx = null;
		Courses courses = null;
		try {
			tx = session.beginTransaction();

			courses = session.get(Courses.class, id);

			session.delete(courses);

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new CourseException("ERROR PLEASE CHEAK.... " + e.getMessage(), e);
		}
		return courses;

	}

}
