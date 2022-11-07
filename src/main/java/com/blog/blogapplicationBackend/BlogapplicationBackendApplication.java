package com.blog.blogapplicationBackend;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;



@SpringBootApplication
public class BlogapplicationBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogapplicationBackendApplication.class, args);
	}

	@Bean
	public  ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
