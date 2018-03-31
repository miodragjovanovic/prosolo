package com.name.no.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student extends User {

	private Integer enrollmentYear;
	@Column(length=10)
	private String indexNo;
	@Column(length=20)
	private String department;
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private List<StudentsCourse> courses = new ArrayList<StudentsCourse>();

	public Integer getEnrollmentYear() {
		return enrollmentYear;
	}

	public void setEnrollmentYear(Integer enrollmentYear) {
		this.enrollmentYear = enrollmentYear;
	}

	public String getIndexNo() {
		return indexNo;
	}

	public void setIndexNo(String indexNo) {
		this.indexNo = indexNo;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<StudentsCourse> getCourses() {
		return courses;
	}

	public void addCourse(StudentsCourse course) {
		this.courses.add(course);
	}

}
