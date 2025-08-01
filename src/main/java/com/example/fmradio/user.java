package com.example.fmradio;

public class user {
    private String name;
    private String availability;

    public user(String name, String availability) {
        this.name = name;
        this.availability = availability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "user{" +
                "name='" + name + '\'' +
                ", availability='" + availability + '\'' +
                '}';
    }

//    public boolean isAvailable() {
//
//    }
}
