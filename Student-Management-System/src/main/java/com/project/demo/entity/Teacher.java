package com.project.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Teacher")
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="teach_id")
	private Integer teachId;
	private String teachName;
	private String teachEmail;
	private Integer number;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="course_Id",referencedColumnName = "course_Id")
	private Courses courses;
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teacher(Integer teachId, String teachName, String teachEmail, Integer number, Courses courses) {
		super();
		this.teachId = teachId;
		this.teachName = teachName;
		this.teachEmail = teachEmail;
		this.number = number;
		this.courses = courses;
	}
	public Integer getTeachId() {
		return teachId;
	}
	public void setTeachId(Integer teachId) {
		this.teachId = teachId;
	}
	public String getTeachName() {
		return teachName;
	}
	public void setTeachName(String teachName) {
		this.teachName = teachName;
	}
	public String getTeachEmail() {
		return teachEmail;
	}
	public void setTeachEmail(String teachEmail) {
		this.teachEmail = teachEmail;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Courses getCourses() {
		return courses;
	}
	public void setCourses(Courses courses) {
		this.courses = courses;
	}
	@Override
	public String toString() {
		return "Teacher [teachId=" + teachId + ", teachName=" + teachName + ", teachEmail=" + teachEmail + ", number="
				+ number + ", courses=" + courses + "]";
	}
	
	
}
