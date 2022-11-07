package com.blog.blogapplicationBackend.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private int id;
    @NotNull
    @Size(min=3,message="username should be bigger than 3 char")
    private String name;
    @Email(message = "invalid email")
    private String email;
    @NotEmpty
    @Size(min=9,message = "minimun 8 char length should be there")
    private String password;

    private String about;

}
