package com.example.example.model.githubmodel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.security.acl.Owner;

public class GithubResponse implements Serializable {

    @SerializedName("id")
    private int id;

//    @SerializedName("archive_url")
//    private String archiveUrl;
//
    @SerializedName("full_name")
    private String fullName;

//    @SerializedName("html_url")
//    private String htmlUrl;
//
//    @SerializedName("name")
//    private String name;
//
//    @SerializedName("git_url")
//    private String gitUrl;
//
    @SerializedName("description")
    private String description;
//
//    @SerializedName("owner")
//    private Owner owner;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public String getArchiveUrl() {
//        return archiveUrl;
//    }
//
//    public void setArchiveUrl(String archiveUrl) {
//        this.archiveUrl = archiveUrl;
//    }
//
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
//
//    public String getHtmlUrl() {
//        return htmlUrl;
//    }
//
//    public void setHtmlUrl(String htmlUrl) {
//        this.htmlUrl = htmlUrl;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getGitUrl() {
//        return gitUrl;
//    }
//
//    public void setGitUrl(String gitUrl) {
//        this.gitUrl = gitUrl;
//    }
//
//    public Owner getOwner() {
//        return owner;
//    }
//
//    public void setOwner(Owner owner) {
//        this.owner = owner;
//    }
//
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
//
//    @Override
//    public String toString() {
//        return "GithubResponse{" +
//                "id=" + id +
//                ", archiveUrl='" + archiveUrl + '\'' +
//                ", fullName='" + fullName + '\'' +
//                ", htmlUrl='" + htmlUrl + '\'' +
//                ", name='" + name + '\'' +
//                ", gitUrl='" + gitUrl + '\'' +
//                ", description='" + description + '\'' +
//                ", owner=" + owner +
//                '}';
//    }
}
