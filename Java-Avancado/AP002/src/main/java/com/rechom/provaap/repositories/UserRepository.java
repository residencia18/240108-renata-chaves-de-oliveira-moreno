package com.rechom.provaap.repositories;

import com.rechom.provaap.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;



public interface UserRepository extends JpaRepository<User, String> {
    
    User findByLogin(String login);
    
    User findByEmail(String email);
}

