package com.name.no.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.name.no.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
