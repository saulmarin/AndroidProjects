package com.marin.saul.noteapp.model;

public class Note {

    public Note(String title) {
        this.title = title;
    }

    private String title;
    private String text;
    private long color;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getColor() {
        return color;
    }

    public void setColor(long color) {
        this.color = color;
    }
}
