package com.project.spring_study_roadmap.dto;

import com.project.spring_study_roadmap.entity.BlogEntity;
import lombok.Builder;

public class BlogDTO {

    private Long id;

    private String title;

    private String content;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Builder
    public BlogDTO(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public BlogEntity toEntity(){
        return BlogEntity.builder()
                .id(id)
                .title(title)
                .content(content)
                .build();
    }

    @Override
    public String toString() {
        return "BlogDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
