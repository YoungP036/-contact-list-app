package com.fury.contacts;

import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fury.contacts.model.User;
import com.fury.contacts.persist.UserRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

    @Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            Stream.of("Patrick Young", "Eric Scott", "Mike Abreau", "Larry Krebs", "Jane Song", "Joy Cornelio", "Terry Patterson").forEach(name -> {
//            	User user = User.builder()
//            			.firstName(StringUtils.split(name)[0])
//            			.lastName(StringUtils.split(name)[1])
//            			.email(StringUtils.replace(name, " ", ".") + "@qvc.com")
//            			.build();
            	User user = new User();
    			user.setFirstName(StringUtils.split(name)[0]);
    			user.setLastName(StringUtils.split(name)[1]);
    			user.setEmail(StringUtils.replace(name, " ", ".") + "@qvc.com");

                userRepository.save(user);
            });
            userRepository.findAll().forEach(System.out::println);
        };
    }
}
