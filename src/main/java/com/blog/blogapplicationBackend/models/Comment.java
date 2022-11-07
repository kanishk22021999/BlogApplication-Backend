package com.blog.blogapplicationBackend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="comments")
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String content;

    //some user commenting
    @ManyToOne
    private User user;
    //comment is being on some post
    @ManyToOne
    private Post post;

}
