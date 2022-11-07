package com.blog.blogapplicationBackend.repository;

import com.blog.blogapplicationBackend.models.Post;
import com.blog.blogapplicationBackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PostRepository extends JpaRepository<Post, Integer> {
List<Post> findByUser(User user);
//find by methods in jpa
}
