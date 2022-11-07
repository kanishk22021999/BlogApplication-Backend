package com.blog.blogapplicationBackend.controllers;

import com.blog.blogapplicationBackend.models.Comment;
import com.blog.blogapplicationBackend.payloads.ApiResponse;
import com.blog.blogapplicationBackend.payloads.CommentDTO;
import com.blog.blogapplicationBackend.servicecontroller.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/post/{postID}/comments")
    public ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO comment, @PathVariable Integer postID)
    {
        CommentDTO createComment = this.commentService.createComment(comment,postID);
        return new ResponseEntity<CommentDTO>(createComment, HttpStatus.CREATED);
    }

    @DeleteMapping("/comments/{commentID}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentID)
    {
        this.commentService.deleteComment(commentID);
        return new ResponseEntity<ApiResponse>(new ApiResponse("deleted successfully",true),HttpStatus.OK);

    }

}
