package com.name.no.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.name.no.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, String> {

}
