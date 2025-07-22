package com.project.spring_study_roadmap.controller;

import com.project.spring_study_roadmap.dto.BlogDTO;
import com.project.spring_study_roadmap.glabal.util.ApiResponse;
import com.project.spring_study_roadmap.glabal.util.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/blog")
@Slf4j
public class BlogController {

    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<ApiResponse<List<BlogDTO>>> blogList() {
        List<BlogDTO> list = blogService.getDetails();

        log.info("list: " + list);

        return ResponseEntity.ok(ApiResponse.success(list, ResponseMessage.SUCCESS));
    }
}
