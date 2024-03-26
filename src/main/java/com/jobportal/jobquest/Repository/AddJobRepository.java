package com.jobportal.jobquest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jobportal.jobquest.Model.AddJobModel;

@Repository
public interface AddJobRepository extends JpaRepository<AddJobModel, Long> {
    // You can add custom query methods if needed
}
