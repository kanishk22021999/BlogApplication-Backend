package com.blog.blogapplicationBackend.repository;

import com.blog.blogapplicationBackend.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Integer> {
}
