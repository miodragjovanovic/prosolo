package com.name.no.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;

	@OneToOne
	private TeacherCreator creator;
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private List<StudentsCourse> studentsCourses = new ArrayList<StudentsCourse>();

	@ManyToMany//(mappedBy = "courses", cascade = CascadeType.ALL)
	private List<Teacher> realisators = new ArrayList<Teacher>();

	public Long getId() {
		return id;
	}

	public List<StudentsCourse> getStudentsCourses() {
		return studentsCourses;
	}

	public void addStudentsCourse(StudentsCourse studentsCourse) {
		this.studentsCourses.add(studentsCourse);
	}

	public TeacherCreator getCreator() {
		return creator;
	}

	public void setCreator(TeacherCreator creator) {
		this.creator = creator;
	}

	public List<Teacher> getRealisators() {
		return realisators;
	}

	public void addRealisator(Teacher realisator) {
		this.realisators.add(realisator);
	}

}
