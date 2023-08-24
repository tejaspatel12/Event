package com.example.event.models;

public class Event {
    private int id;
    private String name;
    private String date;
    private String location;
    private String imageUrl;

    public Event(int id, String name, String date, String location, String imageUrl) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.location = location;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return name;
    }
}
