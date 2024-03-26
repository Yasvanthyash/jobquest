package com.jobportal.jobquest.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.jobquest.Model.*;
import com.jobportal.jobquest.Repository.*;

@Service
public class AddJobService {
    @Autowired
    private AddJobRepository addJobRepository;

    public List<AddJobModel> getAllJob() {
        return addJobRepository.findAll();
    }

    public Optional<AddJobModel> getJobById(Long id) {
        return addJobRepository.findById(id);
    }

    public AddJobModel saveJob(AddJobModel user) {
        return addJobRepository.save(user);
    }
    public void deleteJob(Long id) {
        addJobRepository.deleteById(id);
    }
}