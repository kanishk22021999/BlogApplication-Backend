package com.blog.blogapplicationBackend.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor //jab bhi user ka object bnana hoga toh noargsconstructors
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "user_name", nullable = false, length= 225)
    private String name;
    @Column(name = "email_id",nullable = false)
    private String email;
    @Column(name = "user_pass",nullable = false)
    private String password;
    @Column(name="about_user")
    private String about;

    @OneToMany(mappedBy = "user",cascade= CascadeType.ALL,fetch= FetchType.LAZY)
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)//mapped by jisse foreign key sirf comment table m bne
    private Set<Comment> comments = new HashSet<>();
}
