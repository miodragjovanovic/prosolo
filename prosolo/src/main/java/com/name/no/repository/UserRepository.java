package com.name.no.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.name.no.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
