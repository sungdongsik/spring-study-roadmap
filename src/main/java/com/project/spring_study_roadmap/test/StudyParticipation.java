package com.project.spring_study_roadmap.test;

import jakarta.persistence.*;

@Entity
public class StudyParticipation {

    @Id
    @Column(name = "SP_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long spId;

    @ManyToOne
    private User user;

    @ManyToOne
    private Study study;

    @Enumerated(EnumType.STRING)
    private StatusEnum statusEnum;
}
