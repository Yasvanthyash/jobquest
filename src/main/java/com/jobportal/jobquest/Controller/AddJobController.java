package com.jobportal.jobquest.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.jobquest.Model.AddJobModel;
import com.jobportal.jobquest.Service.AddJobService;

@RestController
@RequestMapping("/api/AddJob")
@CrossOrigin(origins = "http://localhost:5173/", allowedHeaders = "*")

public class AddJobController {
    @Autowired
    private AddJobService addJobService;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public List<AddJobModel> getAllJob() {
        return addJobService.getAllJob();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public AddJobModel getJobById(@PathVariable Long id) {
        return addJobService.getJobById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public AddJobModel saveJob(@RequestBody AddJobModel user) {
        return addJobService.saveJob(user);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteJob(@PathVariable Long id) {
        addJobService.deleteJob(id);
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<AddJobModel> updateJob(
            @PathVariable("id") Long id,
            @RequestBody AddJobModel updatedJob) {
            Optional<AddJobModel> existingJob = addJobService.getJobById(id);

        if (existingJob.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        existingJob.get().setTitle(updatedJob.getTitle());
        existingJob.get().setLocation(updatedJob.getLocation());
        existingJob.get().setTime(updatedJob.getTime());
        existingJob.get().setCompany(updatedJob.getCompany());
        existingJob.get().setDescription(updatedJob.getDescription());

        AddJobModel savedJob = addJobService.saveJob(existingJob.get());

        return ResponseEntity.ok(savedJob);
    }
}