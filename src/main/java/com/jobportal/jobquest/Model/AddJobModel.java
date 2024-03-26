package com.jobportal.jobquest.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="jobs")
public class AddJobModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String image;
    private String title;
    private String time;
    private String location;
    private String description;
    private String company;

    public AddJobModel() {
    }

    public AddJobModel(long id, String image, String title, String time, String location, String description, String company) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.time = time;
        this.location = location;
        this.description = description;
        this.company = company;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
