package com.project1.StudentManagement.config;


import com.project1.StudentManagement.model.Users;
import com.project1.StudentManagement.repository.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner loadSampleData(UsersRepository usersRepositorysers, PasswordEncoder passwordEncoder){


        return args -> {
            if (!usersRepositorysers.existsByUsername("Admin")){
                Users users = new Users();
                users.setUsername("Admin");
                users.setPassword(passwordEncoder.encode("Admin@123"));
                users.setActive(true);
                usersRepositorysers.save(users);

            }
        };

    }
}
