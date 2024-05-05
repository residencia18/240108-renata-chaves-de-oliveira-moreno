package com.renatachom.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.renatachom.springsecurity.entities.UserActivity;

@Repository
public interface UserActivityRepository extends JpaRepository<UserActivity, Long> {
   
}
