package com.example.checkpointSpring.controllers;

import com.example.checkpointSpring.entity.Post;
import com.example.checkpointSpring.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/posts")
    public List<Post> getPosts(){
        return postRepository.findAll();
    }

}
