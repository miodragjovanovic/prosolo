package com.name.no.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.name.no.constant.Constants;
import com.name.no.enums.Privilege;
import com.name.no.excpetion.OnlineCourseException;
import com.name.no.model.Course;
import com.name.no.model.Student;
import com.name.no.model.Teacher;
import com.name.no.model.TeacherCreator;
import com.name.no.repository.CourseRepository;
import com.name.no.repository.StudentRepository;
import com.name.no.repository.TeacherCreatorRepository;
import com.name.no.repository.TeacherRepository;

@Service
public class HelperService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private TeacherCreatorRepository teacherCreatorRepository;
	
	@Autowired
	private OnlineCourseSerivce service;
	
	public String initialize() throws OnlineCourseException {
		Student student1 = new Student();
		student1.setDepartment("rti");
		student1.setEnrollmentYear(2015);
		student1.setFirstName("mika");
		student1.setIndexNo("15/121");
		student1.setLastName("mikic");
		student1.setUsername("mikamikic150121");
		studentRepository.save(student1);
		
		Student student2 = new Student();
		student2.setDepartment("rti");
		student2.setEnrollmentYear(2014);
		student2.setFirstName("pera");
		student2.setIndexNo("14/125");
		student2.setLastName("peric");
		student2.setUsername("peraperic140125");
		studentRepository.save(student2);
		
		Student student3 = new Student();
		student3.setDepartment("tel");
		student3.setEnrollmentYear(2013);
		student3.setFirstName("ivan");
		student3.setIndexNo("13/222");
		student3.setLastName("ivic");
		student3.setUsername("ivanivic130222");
		studentRepository.save(student3);
		
		Student student4 = new Student();
		student4.setDepartment("tel");
		student4.setEnrollmentYear(2005);
		student4.setFirstName("maja");
		student4.setIndexNo("05/121");
		student4.setLastName("majic");
		student4.setUsername("majamajic050121");
		studentRepository.save(student4);
		
		Student student5 = new Student();
		student5.setDepartment("rti");
		student5.setEnrollmentYear(2015);
		student5.setFirstName("student");
		student5.setIndexNo("15/122");
		student5.setLastName("bezkursa");
		student5.setUsername("studentbezkursa150122");
		studentRepository.save(student5);
		
		Student student6 = new Student();
		student6.setDepartment("tel");
		student6.setEnrollmentYear(2010);
		student6.setFirstName("iovaj");
		student6.setIndexNo("10/345");
		student6.setLastName("bezkursa");
		student6.setUsername("iovajbezkursa100345");
		studentRepository.save(student6);
		
		Teacher teacher = new Teacher();
		teacher.setFirstName("jova");
		teacher.setLastName("jovic");
		teacher.setUsername("jovajovic");
		teacher.setAddress("home");
		teacher.setPhone("064/1122333");
		teacher.setTitle("dr");
		teacherRepository.save(teacher);
		
		TeacherCreator teacherCreator = new TeacherCreator();
		teacherCreator.setFirstName("ivka");
		teacherCreator.setLastName("ivic");
		teacherCreator.setUsername("ivkaivic");
		teacherCreator.setAddress("kuca");
		teacherCreator.setPhone("061/1122333");
		teacherCreator.setTitle("mr");
		teacherCreator.addPrivilege(Privilege.COURSE_ADD);
		teacherCreator.addPrivilege(Privilege.COURSE_DELETE);
		teacherCreator.addPrivilege(Privilege.COURSE_EDIT);
		teacherCreatorRepository.save(teacherCreator);
		
		Course course1 = new Course();
		course1.addRealisator(teacher);
		course1.setCreator(teacherCreator);
		courseRepository.save(course1);
		
		Course course2 = new Course();
		course2.addRealisator(teacherCreator);
		course2.addRealisator(teacher);
		course2.setCreator(teacherCreator);
		courseRepository.save(course2);
		
		Course course3 = new Course();
		course3.addRealisator(teacherCreator);
		course3.addRealisator(teacher);
		course3.setCreator(teacherCreator);
		courseRepository.save(course3);
		
		
		service.addStudentToCourse(student1.getUsername(), teacher.getUsername(), course1.getId());
		service.gradeStudent(student1.getUsername(), course1.getId(), 6);
		
		service.addStudentToCourse(student1.getUsername(), teacher.getUsername(), course2.getId());
		service.gradeStudent(student1.getUsername(), course2.getId(), 8);
		
		service.addStudentToCourse(student2.getUsername(), teacher.getUsername(), course1.getId());
		service.gradeStudent(student2.getUsername(), course1.getId(), 7);
		
		service.addStudentToCourse(student3.getUsername(), teacherCreator.getUsername(), course2.getId());
		service.gradeStudent(student3.getUsername(), course2.getId(), 10);
		
		service.addStudentToCourse(student4.getUsername(), teacherCreator.getUsername(), course2.getId());
		service.gradeStudent(student4.getUsername(), course2.getId(), 6);
		
		return Constants.SUCCESS;
	
	}

}
