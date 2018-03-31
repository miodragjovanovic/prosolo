package com.name.no.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.name.no.constant.Constants;
import com.name.no.excpetion.OnlineCourseException;
import com.name.no.service.HelperService;
import com.name.no.service.OnlineCourseSerivce;

@RequestMapping("/api")
@RestController
public class OnlineCourseController {
	
	@Autowired
	private OnlineCourseSerivce service;
	
	@Autowired
	private HelperService helperService;
	
	@RequestMapping("/assignStudentToCourse")
	public String assignStudentToCourse(@RequestParam("studentId") String studentId, @RequestParam("teacherId") String teacherId, @RequestParam("courseId") Long courseId) {
		
		try {
			service.addStudentToCourse(studentId, teacherId, courseId);
		} catch (OnlineCourseException e) {
			return e.getMessage(); 
		}
		
		return Constants.SUCCESS_ADDING_STUDENT_TO_COURSE;
	}
	
	@RequestMapping("/gradeStudent")
	public String gradeStudent(@RequestParam("studentId") String studentId, @RequestParam("courseId") Long courseId, @RequestParam("grade") Integer grade) {
		
		try {
			service.gradeStudent(studentId, courseId, grade);
		} catch (OnlineCourseException e) {
			return e.getMessage(); 
		}
		
		return Constants.SUCCESS_GRADING_THE_STUDENT;
	}
	
	@RequestMapping("/getStudentsFromCourse")
	public Object getStudentsFromCourse(@RequestParam("courseId") Long courseId) {
		
		try {
			List<String> students = service.getStudentsFromCourse(courseId);
			if (students.isEmpty()) {
				return Constants.NO_STUDENTS_ADDED;
			} 
			return students;
		} catch (OnlineCourseException e) {
			return e.getMessage(); 
		}
		
	}
	
	@RequestMapping("/getBestDepartment")
	public Object getBestDepartment() {
		
		return service.getBestDepartment();
		
	}
	
	@RequestMapping("/initialize")
	public Object initialize() {
		
		try {
			return helperService.initialize();
		} catch (OnlineCourseException e) {
			return e.getMessage(); 
		}
		
	}
	

}
