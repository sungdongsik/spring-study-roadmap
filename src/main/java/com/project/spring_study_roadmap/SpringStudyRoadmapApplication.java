package com.project.spring_study_roadmap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringStudyRoadmapApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringStudyRoadmapApplication.class, args);
	}

}
