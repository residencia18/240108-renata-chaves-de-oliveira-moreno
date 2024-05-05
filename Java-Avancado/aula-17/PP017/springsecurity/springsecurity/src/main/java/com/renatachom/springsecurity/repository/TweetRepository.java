package com.renatachom.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.renatachom.springsecurity.entities.Tweet;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {

}