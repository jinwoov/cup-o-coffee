package com.example.newmanTester.models;

public class SampleResponse {
    private long id;
    private String message;
    private String description;

    public SampleResponse(String desc) {
        this.description = desc;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String msg) {
        this.message = msg;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDesc() {
        return description;
    }
}
