package com.name.no.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.name.no.model.id.StudentCourseId;

@Entity
@Table(name = "students_course")
@IdClass(StudentCourseId.class)
public class StudentsCourse {

	@Id
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
	private Course course;
	@Id
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "username")
	private Student student;
	
	private Integer grade;
	
	@OneToOne
	@JoinColumn(name = "teacher_id", referencedColumnName = "username")
	private Teacher teacher;

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}


}
