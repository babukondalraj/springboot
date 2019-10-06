package com.sis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sis.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
