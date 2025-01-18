package com.example.backend.repositories;

import com.example.backend.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findByGoogleId(String googleId);
    boolean existsByGoogleId(String googleId);

    @Query("SELECT u FROM UserEntity u WHERE u.email = :username OR u.googleId = :username")
    Optional<UserEntity> findByUsername(@Param("username") String username);
}
