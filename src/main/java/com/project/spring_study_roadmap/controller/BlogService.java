package com.project.spring_study_roadmap.controller;

import com.project.spring_study_roadmap.dto.BlogDTO;
import com.project.spring_study_roadmap.entity.BlogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService {

    private BlogRepository blogRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public List<BlogDTO> getDetails(){

        List<BlogEntity> all = blogRepository.findByBlogList();

        return all.stream()
                .map(blog -> new BlogDTO(blog.getId(), blog.getTitle(), blog.getContent()))
                .collect(Collectors.toList());
    }
}
