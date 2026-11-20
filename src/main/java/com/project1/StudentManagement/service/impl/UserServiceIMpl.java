package com.project1.StudentManagement.service.impl;

import com.project1.StudentManagement.model.Users;
import com.project1.StudentManagement.repository.UsersRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIMpl implements UserDetailsService {


   private UsersRepository usersRepository;

   public UserServiceIMpl(UsersRepository usersRepository){
       this.usersRepository = usersRepository;
   }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.project1.StudentManagement.model.Users users = usersRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Invalid username"));

        return org.springframework.security.core.userdetails.User
                .withUsername(users.getUsername())
                .password(users.getPassword())
                .roles("USER") // or map from users.getRole() if you have a role field
                .disabled(!users.isActive())
                .build();
    }
}
