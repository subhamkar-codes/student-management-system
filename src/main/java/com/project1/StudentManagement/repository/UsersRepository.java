package com.project1.StudentManagement.repository;

import com.project1.StudentManagement.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,Long> {

    boolean existsByUsername(String username);
        Optional<Users> findByUsername(String username);
}
