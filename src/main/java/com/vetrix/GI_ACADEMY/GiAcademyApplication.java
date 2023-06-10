package com.vetrix.GI_ACADEMY;

import com.vetrix.GI_ACADEMY.compte.Compte;
import com.vetrix.GI_ACADEMY.compte.CompteRepository;
import com.vetrix.GI_ACADEMY.compte.Role;
import com.vetrix.GI_ACADEMY.file.FileStorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableConfigurationProperties({FileStorageProperties.class})
public class GiAcademyApplication {

	@Autowired
	private CompteRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(GiAcademyApplication.class, args);
	}

	@PostConstruct
	public void initUsers() {
		repository.save(new Compte("admin","0000", Role.ADMIN));
	}

}
