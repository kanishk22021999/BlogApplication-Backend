package com.blog.blogapplicationBackend.controllers;


import com.blog.blogapplicationBackend.models.Post;
import com.blog.blogapplicationBackend.payloads.ApiResponse;
import com.blog.blogapplicationBackend.payloads.PostDTO;
import com.blog.blogapplicationBackend.servicecontroller.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class PostController {
    @Autowired
    private PostService postService;

    //create post
    @PostMapping("user/{userID}/posts")
    public ResponseEntity<PostDTO> createPost(
            @RequestBody PostDTO postDTO, @PathVariable Integer userID)
    {
     PostDTO createPost= this.postService.createPost(postDTO,userID);
     return new ResponseEntity<PostDTO>(createPost, HttpStatus.CREATED);
    }

    //get posts by user
    @GetMapping("user/{userID}/posts")
    public ResponseEntity<List<PostDTO>> getPostsByUser(@PathVariable Integer userID){
        List<PostDTO> posts= this.postService.getPostsByUser(userID);
        return new ResponseEntity<List<PostDTO>>(posts,HttpStatus.OK);
    }
    //get all the posts
    @GetMapping("posts")
    public ResponseEntity<List<PostDTO>> getAllPost(){
        List<PostDTO> allPost = this.postService.getAllPost();
        return new ResponseEntity<List<PostDTO>>(allPost,HttpStatus.OK);
    }

    // get posts by id
    @GetMapping("posts/{postID}")
    public ResponseEntity<PostDTO> getPostByID(@PathVariable Integer postID){
        PostDTO postDTO = this.postService.getPostByID(postID);
        return new ResponseEntity<PostDTO>(postDTO,HttpStatus.OK);

    }
    //delete post

    @DeleteMapping("posts/{postID}")
    public ApiResponse deletePost(@PathVariable Integer postID){
        this.postService.deletePost(postID);
        return new ApiResponse("Post is successfully deleted",true);
    }

    //update post
    @PutMapping("posts/{postID}")
    public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO postDTO, @PathVariable Integer postID){
        PostDTO updatedPost= this.postService.updatePost(postDTO,postID);
        return  new ResponseEntity<PostDTO>(updatedPost,HttpStatus.OK);
    }
}
