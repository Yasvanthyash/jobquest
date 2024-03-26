package com.jobportal.jobquest.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String dob;
    private String email;
    private String mobile;
    private String gender;
    private String qualification;
    private String collegename;
    private String location;
    private String cgpa;
    private String state;
    private String companyName;
    private String  jobName;
    private String experience;
    private String  skills;
    private String languages;
    private String coverLetter;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getCollegename() {
        return collegename;
    }

    public void setCollegename(String collegename) {
        this.collegename = collegename;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
    public String getCoverLetter() {
        return coverLetter;
    }

    public void setCoverLetter(String coverLetter) {
        this.coverLetter = coverLetter;
    }
    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }
}