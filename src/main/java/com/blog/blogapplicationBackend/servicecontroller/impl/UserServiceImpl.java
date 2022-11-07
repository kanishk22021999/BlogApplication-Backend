package com.blog.blogapplicationBackend.servicecontroller.impl;

import com.blog.blogapplicationBackend.exceptions.ResourceNotFoundException;
import com.blog.blogapplicationBackend.models.User;
import com.blog.blogapplicationBackend.payloads.UserDTO;
import com.blog.blogapplicationBackend.repository.UserRepository;
import com.blog.blogapplicationBackend.servicecontroller.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = this.dTOTOUser(userDTO);
        User savedUser = this.userRepository.save(user);
        return this.userToDTO(savedUser);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Integer userID) {
        User user = this.userRepository.findById(userID).orElseThrow(()-> new ResourceNotFoundException("resource not found with id"+ userID, "user id:", userID));
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setAbout(userDTO.getAbout());

        User updatedUser = this.userRepository.save(user);
        UserDTO userDTO1 = this.userToDTO(updatedUser);
        return userDTO1;
    }

    @Override
    public UserDTO getUserById(Integer userID) {
        User user = this.userRepository.findById(userID).orElseThrow(()-> new ResourceNotFoundException("resource not found with id"+ userID, "user id:", userID));
        return this.userToDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = this.userRepository.findAll();
        List<UserDTO> userDTOS = users.stream().map(user->this.userToDTO(user)).collect(Collectors.toList());
        return userDTOS ;
    }

    @Override
    public void deleteUser(Integer userID) {
        User user = this.userRepository.findById(userID).orElseThrow(()-> new ResourceNotFoundException("resource not found with id"+ userID, "user id:", userID));
        this.userRepository.delete(user);

    }

    private User dTOTOUser(UserDTO userDTO)
    {
        User user = this.modelMapper.map(userDTO,User.class);
//        User user = new User();
//        user.setId(userDTO.getId());
//        user.setName(userDTO.getName());
//        user.setEmail(userDTO.getEmail());
//        user.setAbout(userDTO.getAbout());
//        user.setPassword(userDTO.getPassword());
        return user;
    }
    private UserDTO userToDTO(User user)
    {
     UserDTO userDTO= this.modelMapper.map(user,UserDTO.class);
//     UserDTO userDTO= new UserDTO();
//     userDTO.setId(user.getId());
//     userDTO.setName(user.getName());
//     userDTO.setEmail(user.getEmail());
//     userDTO.setAbout(user.getAbout());
//     userDTO.setPassword(user.getPassword());
     return userDTO;
    }
}
