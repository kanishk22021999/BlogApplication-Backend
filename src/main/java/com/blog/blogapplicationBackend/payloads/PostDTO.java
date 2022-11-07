package com.blog.blogapplicationBackend.payloads;

import com.blog.blogapplicationBackend.models.Comment;
import com.blog.blogapplicationBackend.models.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class PostDTO {
    private String title;

    private String content;

    private UserDTO user;
    //did this after an error encountered, creating infinite recursion
    private Set<Comment> comments = new HashSet<>();
    //added this to get comments from posts
}
