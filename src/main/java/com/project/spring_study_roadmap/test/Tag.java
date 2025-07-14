package com.project.spring_study_roadmap.test;

import jakarta.persistence.*;
import lombok.Builder;

import java.util.List;

@Entity
public class Tag {

    @Id
    @Column(name = "TAG_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;

    private String tagName;

    @ManyToMany(mappedBy = "tags")
    private List<Study> studies;

    public Long getTagId() {
        return tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public List<Study> getStudies() {
        return studies;
    }

    @Builder
    public Tag(Long tagId, String tagName, List<Study> studies) {
        this.tagId = tagId;
        this.tagName = tagName;
        this.studies = studies;
    }
}
