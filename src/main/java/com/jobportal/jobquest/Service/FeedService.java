package com.jobportal.jobquest.Service;

// import com.admission.demo.Model.Feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jobportal.jobquest.Repository.*;
// import com.admission.demo.Repository.FeedRepo;

import com.jobportal.jobquest.Model.Feedback;

import java.util.List;
import java.util.Optional;

@Service
public class FeedService {

    @Autowired
    private FeedRepo FeedRepo;

    public List<Feedback> getAllFeed() {
        return FeedRepo.findAll();
    }

    public Optional<Feedback> getFeedById(Long id) {
        return FeedRepo.findById(id);
    }

    public Feedback createFeed(Feedback Feed) {
        return FeedRepo.save(Feed);
    }

    public Feedback updateFeed(Long id, Feedback updatedFeed) {
        Optional<Feedback> Feed = FeedRepo.findById(id);
        if (Feed.isPresent()) {
            updatedFeed.setId(id);
            return FeedRepo.save(updatedFeed);
        } else {
            throw new RuntimeException("Feedback not found");
        }
    }

    public void deleteFeed(Long id) {
        FeedRepo.deleteById(id);
    }
}