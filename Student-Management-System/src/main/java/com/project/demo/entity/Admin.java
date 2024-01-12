package com.project.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Ad_Id")
	private Integer adminId;
	private String adName;

	private String adPassword;
	// In Admin class
	@OneToMany
	private List<Courses> courses;

	public Admin() {

	}

	public Admin(Integer adminId, String adName, String adPassword, List<Courses> courses) {
		super();
		this.adminId = adminId;
		this.adName = adName;
		this.adPassword = adPassword;
		this.courses = courses;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdName() {
		return adName;
	}

	public void setAdName(String adName) {
		this.adName = adName;
	}

	public String getAdPassword() {
		return adPassword;
	}

	public void setAdPassword(String adPassword) {
		this.adPassword = adPassword;
	}

	public List<Courses> getCourses() {
		return courses;
	}

	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adName=" + adName + ", adPassword=" + adPassword + ", courses="
				+ courses + "]";
	}

	
	

	
}
