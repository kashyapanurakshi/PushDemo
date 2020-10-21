package com.example.firebaseuifirestoreexample;

public class Note {
    private String title;
    private String description;
    private int priority;

    public Note(){
        //no content needed
    }

    public Note(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }
}
