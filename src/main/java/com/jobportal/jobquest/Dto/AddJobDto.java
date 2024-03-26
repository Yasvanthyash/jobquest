package com.jobportal.jobquest.Dto;


public class AddJobDto {
    private long id;
    private String image;
    private String title;
    private String time;
    private String location;
    private String desc;
    private String company;

    public AddJobDto() {
    }

    public AddJobDto(long id, String image, String title, String time, String location, String desc, String company) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.time = time;
        this.location = location;
        this.desc = desc;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
