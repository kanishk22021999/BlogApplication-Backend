package com.blog.blogapplicationBackend.servicecontroller;

import com.blog.blogapplicationBackend.payloads.CommentDTO;

public interface CommentService {
    CommentDTO createComment(CommentDTO commentDTO,Integer postID);

    void deleteComment(Integer commentID);
}
