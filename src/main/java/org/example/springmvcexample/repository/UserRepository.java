package org.example.springmvcexample.repository;

import org.example.springmvcexample.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query("select u from UserEntity u where u.email = :email")
    Optional<UserEntity> findUsersByEmail(@Param("email") String email);
}
