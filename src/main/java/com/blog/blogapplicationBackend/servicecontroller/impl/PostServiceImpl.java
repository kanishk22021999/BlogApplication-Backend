package com.blog.blogapplicationBackend.servicecontroller.impl;

import com.blog.blogapplicationBackend.exceptions.ResourceNotFoundException;
import com.blog.blogapplicationBackend.models.Post;
import com.blog.blogapplicationBackend.models.User;
import com.blog.blogapplicationBackend.payloads.PostDTO;
import com.blog.blogapplicationBackend.repository.PostRepository;
import com.blog.blogapplicationBackend.repository.UserRepository;
import com.blog.blogapplicationBackend.servicecontroller.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service//to make conpenent of spring cont
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;

    @Override
    public PostDTO createPost(PostDTO postDTO,Integer userID) {
        User user= this.userRepository.findById(userID).
                orElseThrow(()-> new ResourceNotFoundException("User","user id:",userID));

        Post post = this.modelMapper.map(postDTO,Post.class);
        //here we get only title and content
        //set user
        post.setUser(user);
        Post newPost = this.postRepository.save(post);

        return this.modelMapper.map(newPost,PostDTO.class);
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO, Integer postID) {
        Post post=  this.postRepository.findById(postID).orElseThrow
                (()->new ResourceNotFoundException("post not found","post id:",postID));
        post.setTitle(post.getTitle());
        post.setContent(post.getContent());
        Post updatedPost = this.postRepository.save(post);
        return this.modelMapper.map(updatedPost, PostDTO.class);
    }

    @Override
    public void deletePost(Integer postID) {
       Post post=  this.postRepository.findById(postID).orElseThrow(()->new ResourceNotFoundException("post not found","post id:",postID));
       this.postRepository.delete(post);
    }

    @Override
    public List<PostDTO> getAllPost() {
        List<Post> allPosts = this.postRepository.findAll();
        List<PostDTO> postDTOs= allPosts.stream().map((post) -> this.modelMapper.map(post, PostDTO.class)).collect(Collectors.toList());
         return postDTOs;
    }

    @Override
    public PostDTO getPostByID(Integer postID) {
        Post post = this.postRepository.findById(postID).orElseThrow(()-> new ResourceNotFoundException("post","post id",postID));
        return this.modelMapper.map(post,PostDTO.class);
    }

    @Override
    public List<PostDTO> getPostsByUser(Integer userID) {
        User user= this.userRepository.findById(userID).orElseThrow
                (()->new ResourceNotFoundException("User","userID", userID));
        List<Post> posts= this.postRepository.findByUser(user);
        //bit tricky part we need postdto not posts so converting them
        List<PostDTO> postDTOs= posts.stream().map((post) -> this.modelMapper.map(post, PostDTO.class)).collect(Collectors.toList());
        return postDTOs;
    }
}
