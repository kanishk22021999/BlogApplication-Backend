package com.blog.blogapplicationBackend.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="posts")
@Getter
@Setter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer postId;
    //can use @Column(name=" " , lenght)
    private String title;
    private String content;
    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)//mapped by jisse foreign key sirf comment table m bne
    private Set<Comment> comments = new HashSet<>();

}
