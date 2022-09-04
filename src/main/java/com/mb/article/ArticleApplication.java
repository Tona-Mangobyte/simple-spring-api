package com.mb.article;

import com.mb.article.common.UserRole;
import com.mb.article.models.User;
import com.mb.article.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Optional;

@SpringBootApplication
public class ArticleApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(ArticleApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		User alreadySetup = this.userRepository.findByUsername("admin@mb.com");
		if (alreadySetup != null)
			return;

		User adminUser = new User();
		adminUser.setUsername("admin@mb.com");
		adminUser.setPassword(passwordEncoder.encode("admin@12345"));
		adminUser.setRole(UserRole.ADMIN_ROLE);
		userRepository.save(adminUser);

		User user = new User();
		user.setUsername("user@mb.com");
		user.setPassword(passwordEncoder.encode("user@12345"));
		user.setRole(UserRole.USER_ROLE);
		userRepository.save(user);
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
}
