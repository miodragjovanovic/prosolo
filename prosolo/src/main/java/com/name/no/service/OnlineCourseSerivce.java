package com.name.no.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.name.no.constant.Constants;
import com.name.no.excpetion.OnlineCourseException;
import com.name.no.helper.DepartmentAverage;
import com.name.no.model.Course;
import com.name.no.model.Student;
import com.name.no.model.StudentsCourse;
import com.name.no.model.Teacher;
import com.name.no.model.id.StudentCourseId;
import com.name.no.repository.CourseRepository;
import com.name.no.repository.StudentCourseRepository;
import com.name.no.repository.StudentRepository;
import com.name.no.repository.TeacherRepository;

@Service
public class OnlineCourseSerivce {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired StudentCourseRepository studentCourseRepository;
	
	public void addStudentToCourse(String studentId, String teacherId, Long courseId) throws OnlineCourseException {
		Optional<Course> course = courseRepository.findById(courseId);
		if (!course.isPresent()) { 
			throw new OnlineCourseException(Constants.NON_EXISTING_COURSE);
		}
		Optional<Teacher> teacher = teacherRepository.findById(teacherId);
		if (!teacher.isPresent()) { 
			throw new OnlineCourseException(Constants.NON_EXISTING_TEACHER);
		}
		Optional<Student> student = studentRepository.findById(studentId);
		if (!student.isPresent()) { 
			throw new OnlineCourseException(Constants.NON_EXISTING_STUDENT);
		}
		
		if (!checkRealistaor(course.get(), teacher.get())) {
			throw new OnlineCourseException(Constants.TEACHER_NOT_COURSE_REALISATOR);
		}
		
		StudentCourseId studentCourseId = new StudentCourseId();
		studentCourseId.setCourse(courseId);
		studentCourseId.setStudent(studentId);
		
		Optional<StudentsCourse> existingStudentsCourse = studentCourseRepository.findById(studentCourseId);
		if (existingStudentsCourse.isPresent()) { 
			throw new OnlineCourseException(Constants.STUDENT_ALREADY_ADDED_TO_COURSE);
		}
		
		StudentsCourse studentsCourse = new StudentsCourse();
		studentsCourse.setCourse(course.get());
		studentsCourse.setTeacher(teacher.get());
		studentsCourse.setStudent(student.get());
		
		course.get().addStudentsCourse(studentsCourse);
		courseRepository.save(course.get());
		student.get().addCourse(studentsCourse);
		studentRepository.save(student.get());
	}
	
	public void gradeStudent(String studentId, Long courseId, Integer grade) throws OnlineCourseException {
		StudentCourseId studentCourseId = new StudentCourseId();
		studentCourseId.setCourse(courseId);
		studentCourseId.setStudent(studentId);
		
		Optional<StudentsCourse> existingStudentsCourse = studentCourseRepository.findById(studentCourseId);
		if (!existingStudentsCourse.isPresent()) { 
			throw new OnlineCourseException(Constants.STUDENT_NOT_ADDED_TO_COURSE);
		}
		existingStudentsCourse.get().setGrade(grade);
		studentCourseRepository.save(existingStudentsCourse.get());
	}
	
	public List<String> getStudentsFromCourse(Long courseId) throws OnlineCourseException {
		Optional<Course> course = courseRepository.findById(courseId);
		if (!course.isPresent()) { 
			throw new OnlineCourseException(Constants.NON_EXISTING_COURSE);
		}
		
		List<Student> students = studentCourseRepository.getStudentsOnCourse(courseId);
		
		List<String> names = new ArrayList<String>();
		for (Student student : students) {
			names.add(student.getUsername());
		}
		
		return names;
	}
	
	public String getBestDepartment() {
		
		int year = Calendar.getInstance().get(Calendar.YEAR);
		List<DepartmentAverage> dep = studentCourseRepository.getDepatments(year - 5);
		if (dep.isEmpty()) {
			return Constants.NO_STUDENTS_IN_LAST_FIVE_YEARS;
		}
		return dep.get(0).getDepartment();
		
	}
	
	private boolean checkRealistaor(Course course, Teacher teacher) {
		boolean found = false;
		List<Teacher> realisators = course.getRealisators();
		for (Teacher realisator : realisators) {
			if (realisator.getUsername().equals(teacher.getUsername())) {
				found = true;
				break;
			}
		}
		return found;
	}
}
