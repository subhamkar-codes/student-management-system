package com.project1.StudentManagement.repository;

import com.project1.StudentManagement.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Long> {

    boolean existsByUsername(String username);

}
