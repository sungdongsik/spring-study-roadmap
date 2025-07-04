package com.project.spring_study_roadmap.hellojpa;

import jakarta.persistence.Entity;

@Entity
public class Album extends Item{
    private String artist;
}
