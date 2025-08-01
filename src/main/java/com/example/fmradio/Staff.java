package com.example.fmradio;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Staff {
        private String name;
        private String role;
        private boolean available;
        private String performanceNote;

    public Staff(String name, String role, boolean available, String performanceNote) {
        this.name = name;
        this.role = role;
        this.available = available;
        this.performanceNote = performanceNote;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getPerformanceNote() {
        return performanceNote;
    }

    public void setPerformanceNote(String performanceNote) {
        this.performanceNote = performanceNote;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", available=" + available +
                ", performanceNote='" + performanceNote + '\'' +
                '}';
    }
}
