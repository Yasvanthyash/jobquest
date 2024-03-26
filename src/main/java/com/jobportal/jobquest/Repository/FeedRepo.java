package com.jobportal.jobquest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobportal.jobquest.Model.Feedback;

public interface FeedRepo extends JpaRepository<Feedback, Long> {
}
