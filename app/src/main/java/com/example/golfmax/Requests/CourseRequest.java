package com.example.golfmax.Requests;

public class CourseRequest {

    private String courseName;
    private long id;

    public CourseRequest() {}

    public CourseRequest(String courseName, long id) {
        this.courseName = courseName;
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public long getId() {
        return id;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setId(long id) {
        this.id = id;
    }
}
