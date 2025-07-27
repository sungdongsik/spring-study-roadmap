package com.project.spring_study_roadmap.domain.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class BlogController {

    @GetMapping("/blogs")
    public String getBlog(){
        return "blog";
    }
}
