package com.blog.blogapplicationBackend.servicecontroller;

import com.blog.blogapplicationBackend.models.User;
import com.blog.blogapplicationBackend.payloads.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO user);
    UserDTO updateUser(UserDTO user, Integer userID);
    UserDTO getUserById(Integer userID);
    List<UserDTO> getAllUsers();

    void deleteUser(Integer userID);

}
