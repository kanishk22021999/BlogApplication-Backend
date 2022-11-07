package com.blog.blogapplicationBackend.controllers;

import com.blog.blogapplicationBackend.payloads.ApiResponse;
import com.blog.blogapplicationBackend.payloads.UserDTO;
import com.blog.blogapplicationBackend.servicecontroller.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    private UserService userService;

    //post
    @PostMapping("/")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO){
        UserDTO createUserDTO = this.userService.createUser(userDTO);
        return new ResponseEntity<>(createUserDTO, HttpStatus.CREATED);
    }
    //put
    @PutMapping("/{userID}")
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO, @PathVariable Integer userID ){
        UserDTO updatedUser= this.userService.updateUser(userDTO, userID);
        return ResponseEntity.ok(updatedUser);
    }
    //delete
    @DeleteMapping("/{userID}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userID") Integer userID){
        this.userService.deleteUser(userID);
        return new ResponseEntity<ApiResponse>(new ApiResponse("user deleted",true),HttpStatus.OK);
    }
    //get
    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return ResponseEntity.ok(this.userService.getAllUsers());
    }
    //get by id
    @GetMapping("/{userID}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer userID){
        return ResponseEntity.ok(this.userService.getUserById(userID));
    }

}
