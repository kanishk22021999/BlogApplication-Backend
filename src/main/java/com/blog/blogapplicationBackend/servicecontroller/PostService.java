package com.blog.blogapplicationBackend.servicecontroller;

import com.blog.blogapplicationBackend.models.Post;
import com.blog.blogapplicationBackend.payloads.PostDTO;

import java.util.List;

public interface PostService {

    //create
    PostDTO createPost(PostDTO postDTO,Integer userID);

    //for updating
    PostDTO updatePost(PostDTO postDTO, Integer postID);

    //delete query
    void deletePost(Integer postID);

    //get all posts
    List<PostDTO> getAllPost();

    //get post by post id
    PostDTO getPostByID(Integer postID);

    //get posts by user
    List<PostDTO> getPostsByUser(Integer userID);
}
