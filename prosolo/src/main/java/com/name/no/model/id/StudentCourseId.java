package com.name.no.model.id;

import java.io.Serializable;

public class StudentCourseId implements Serializable {

	private String student;
	private Long course;

	public String getStudent() {
		return student;
	}

	public void setStudent(String student) {
		this.student = student;
	}

	public Long getCourse() {
		return course;
	}

	public void setCourse(Long course) {
		this.course = course;
	}

	public boolean equals(Object object) {
		if (object instanceof StudentCourseId) {
			StudentCourseId otherId = (StudentCourseId) object;
			return (otherId.student.equals(this.student) && (otherId.course == this.course));
		}
		return false;
	}

}
