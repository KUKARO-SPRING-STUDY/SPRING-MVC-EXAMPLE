package org.example.springmvcexample.repository;

import org.example.springmvcexample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
