package com.example.example.model.githubmodel;

import java.io.Serializable;

public class Repo implements Serializable {
    String name;
    String description;

    String profileUrl;


    public Repo(String name) {
        this.name = name;
    }

    public Repo(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Repo(String name, String description, String profileUrl) {
        this.name = name;
        this.description = description;
        this.profileUrl = profileUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    @Override
    public String toString() {
        return "Repo{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", profileUrl='" + profileUrl + '\'' +
                '}';
    }
}
