package com.example.schedulesdevelopproject.repository;

import com.example.schedulesdevelopproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
