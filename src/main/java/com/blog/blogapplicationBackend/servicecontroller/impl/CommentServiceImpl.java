package com.blog.blogapplicationBackend.servicecontroller.impl;

import com.blog.blogapplicationBackend.exceptions.ResourceNotFoundException;
import com.blog.blogapplicationBackend.models.Comment;
import com.blog.blogapplicationBackend.models.Post;
import com.blog.blogapplicationBackend.payloads.CommentDTO;
import com.blog.blogapplicationBackend.repository.CommentRepository;
import com.blog.blogapplicationBackend.repository.PostRepository;
import com.blog.blogapplicationBackend.servicecontroller.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDTO createComment(CommentDTO commentDTO, Integer postID) {
        Post post= this.postRepository.findById(postID).orElseThrow(
                ()-> new ResourceNotFoundException("post","post id",postID));
        Comment comment= this.modelMapper.map(commentDTO, Comment.class);
        comment.setPost(post);
        Comment savedComment= this.commentRepository.save(comment);
        return this.modelMapper.map(savedComment, CommentDTO.class);
    }

    @Override
    public void deleteComment(Integer commentID) {
        Comment comment= this.commentRepository.findById(commentID).orElseThrow(
                ()->new ResourceNotFoundException("comment not found","comment id",commentID));
        this.commentRepository.delete(comment);

    }
}
