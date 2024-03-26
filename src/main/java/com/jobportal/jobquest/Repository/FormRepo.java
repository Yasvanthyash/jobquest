package com.jobportal.jobquest.Repository;

import com.jobportal.jobquest.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepo extends JpaRepository<Form, Long> {
}