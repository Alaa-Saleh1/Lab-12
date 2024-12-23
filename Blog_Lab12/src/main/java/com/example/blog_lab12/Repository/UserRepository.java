package com.example.blog_lab12.Repository;

import com.example.blog_lab12.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserById(Integer id);
    User findUserByUsername(String username);

    List<User> findUserByRole(String role);
}
