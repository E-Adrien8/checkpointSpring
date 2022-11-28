package com.example.checkpointSpring.controllers;


import com.example.checkpointSpring.entity.Comment;
import com.example.checkpointSpring.entity.User;
import com.example.checkpointSpring.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

//    @GetMapping("/comments")
//    public List<Comment> list() {
//        return commentRepository.findAll();
//    }

    @PostMapping("/comments")
    public Comment postComments(@RequestBody Comment comment) {
        return commentRepository.save(comment);
    }

}
