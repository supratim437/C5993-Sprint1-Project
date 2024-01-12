package com.project.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "std_Id")
	private Integer stdId;
	private String stdName;
	private String stdEmail;
	private Integer stdNumber;
	private Integer stdAge;
	@ManyToOne
	@JoinColumn(name = "course_Id")
	private Courses courses;
	
	public Student() {
		
	}

	public Student(Integer stdId, String stdName, String stdEmail, Integer stdNumber, Integer stdAge, Courses courses) {
		super();
		this.stdId = stdId;
		this.stdName = stdName;
		this.stdEmail = stdEmail;
		this.stdNumber = stdNumber;
		this.stdAge = stdAge;
		this.courses = courses;
	}

	public Integer getStdId() {
		return stdId;
	}

	public void setStdId(Integer stdId) {
		this.stdId = stdId;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public String getStdEmail() {
		return stdEmail;
	}

	public void setStdEmail(String stdEmail) {
		this.stdEmail = stdEmail;
	}

	public Integer getStdNumber() {
		return stdNumber;
	}

	public void setStdNumber(Integer stdNumber) {
		this.stdNumber = stdNumber;
	}

	public Integer getStdAge() {
		return stdAge;
	}

	public void setStdAge(Integer stdAge) {
		this.stdAge = stdAge;
	}

	public Courses getCourses() {
		return courses;
	}

	public void setCourses(Courses courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [stdId=" + stdId + ", stdName=" + stdName + ", stdEmail=" + stdEmail + ", stdNumber="
				+ stdNumber + ", stdAge=" + stdAge + ", courses=" + courses + "]";
	}
	
	
}
