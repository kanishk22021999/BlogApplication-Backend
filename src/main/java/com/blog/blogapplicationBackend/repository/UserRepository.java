package com.blog.blogapplicationBackend.repository;

import com.blog.blogapplicationBackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;

public interface UserRepository extends JpaRepository<User, Integer> {
}
