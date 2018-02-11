package com.Thoughts.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Thought {

    @JsonProperty
    private String author;

    @JsonProperty
    private String thought;

    public Thought(String author, String thought) {
        this.author = author;
        this.thought = thought;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getThought() {
        return thought;
    }

    public void setThought(String thought) {
        this.thought = thought;
    }




}
