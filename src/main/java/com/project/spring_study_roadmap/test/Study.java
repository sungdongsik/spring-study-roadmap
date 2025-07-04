package com.project.spring_study_roadmap.test;

import jakarta.persistence.*;
import lombok.Builder;

import java.util.List;

@Entity
public class Study {

    @Id
    @Column(name = "STUDY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studyId;

    @ManyToMany
    @JoinTable(name = "study_tag",
        joinColumns = @JoinColumn(name = "STUDY_ID"),
            inverseJoinColumns = @JoinColumn(name = "TAG_ID")
    )
    private List<Tag> tags;

    @ManyToOne
    @JoinColumn(name = "HOST_ID")
    private User host;

    @Enumerated(EnumType.STRING)
    private StatusEnum statusEnum;

    public Long getStudyId() {
        return studyId;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public User getHost() {
        return host;
    }

    public StatusEnum getStatusEnum() {
        return statusEnum;
    }

    @Builder
    public Study(Long studyId, List<Tag> tags, User host, StatusEnum statusEnum) {
        this.studyId = studyId;
        this.tags = tags;
        this.host = host;
        this.statusEnum = statusEnum;
    }
}
