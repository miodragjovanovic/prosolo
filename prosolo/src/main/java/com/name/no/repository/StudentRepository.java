package com.name.no.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.name.no.model.Student;

public interface StudentRepository extends JpaRepository<Student, String> {

}
