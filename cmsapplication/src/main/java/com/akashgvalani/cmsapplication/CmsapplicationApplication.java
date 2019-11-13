package com.akashgvalani.cmsapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//Performing JPA Repository

@EnableJpaRepositories
@SpringBootApplication
public class CmsapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmsapplicationApplication.class, args);
	}

}
