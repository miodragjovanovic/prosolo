package com.name.no.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.name.no.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {
	
	Admin findByLastName(String lastname);

}
