package com.jobportal.jobquest.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jobportal.jobquest.Model.*;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByEmail(String email);
}