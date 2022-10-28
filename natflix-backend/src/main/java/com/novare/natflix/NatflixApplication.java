package com.novare.natflix;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NatflixApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(NatflixApplication.class, args);
	}

//	@Autowired
//	private RoleRepository roleRepository;

	@Override
	public void run(String... args) throws Exception {

//		Role adminRole = new Role();
//		adminRole.setName(ERole.ROLE_ADMIN);
//		roleRepository.save(adminRole);
//
//		Role userRole = new Role();
//		userRole.setName(ERole.ROLE_CUSTOMER);
//		roleRepository.save(userRole);

	}
}
