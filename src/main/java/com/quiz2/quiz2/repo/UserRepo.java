 package com.quiz2.quiz2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.quiz2.quiz2.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
    @Query("SELECT U FROM User U where U.email = ?1")
    User findByEmail(String email);
}
