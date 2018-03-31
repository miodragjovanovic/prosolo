package com.name.no.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.name.no.helper.DepartmentAverage;
import com.name.no.model.Student;
import com.name.no.model.StudentsCourse;
import com.name.no.model.id.StudentCourseId;

public interface StudentCourseRepository extends JpaRepository<StudentsCourse, StudentCourseId> {
	
	@Query("select s " +
			"from StudentsCourse as sc " +
			"inner join Student as s " +  
			"on s.username = sc.student " +
			"where sc.course.id = :course_id") 
	List<Student> getStudentsOnCourse(@Param("course_id") Long courseId);

	 @Query("select new com.name.no.helper.DepartmentAverage(s.department,  avg(sc.grade) AS avgGrade) " +
			 "from StudentsCourse as sc " +
	         "inner join Student as s " +  
	         "on s.username = sc.student " +
	         "where s.enrollmentYear >= :year " +
	         "group by s.department " +
	         "order by avgGrade DESC ")
	 List<DepartmentAverage> getDepatments(@Param("year") Integer year);
}

