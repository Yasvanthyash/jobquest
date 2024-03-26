package com.jobportal.jobquest.Dto;

public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String  phonenumber;
    private String qualification;
    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public UserDto(Long id, String username, String email,String password,String qualification,String role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.qualification = qualification;
        this.role = role;
    }
}