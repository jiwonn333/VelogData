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
    @SerializedName("owner")
    private Owner owner;

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
    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
//
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public class Owner implements Serializable {
        @SerializedName("gists_url")
        private String gistsUrl;

        @SerializedName("repos_url")
        private String reposUrl;

        @SerializedName("login")
        private String login;

        @SerializedName("type")
        private String type;

        @SerializedName("url")
        private String url;

        @SerializedName("avatar_url")
        private String avatarUrl;

        @SerializedName("id")
        private int id;

        @SerializedName("gravatar_id")
        private String gravatarId;

        @SerializedName("node_id")
        private String nodeId;

        @SerializedName("organizations_url")
        private String organizationsUrl;

        public String getGistsUrl() {
            return gistsUrl;
        }

        public void setGistsUrl(String gistsUrl) {
            this.gistsUrl = gistsUrl;
        }

        public String getReposUrl() {
            return reposUrl;
        }

        public void setReposUrl(String reposUrl) {
            this.reposUrl = reposUrl;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGravatarId() {
            return gravatarId;
        }

        public void setGravatarId(String gravatarId) {
            this.gravatarId = gravatarId;
        }

        public String getNodeId() {
            return nodeId;
        }

        public void setNodeId(String nodeId) {
            this.nodeId = nodeId;
        }

        public String getOrganizationsUrl() {
            return organizationsUrl;
        }

        public void setOrganizationsUrl(String organizationsUrl) {
            this.organizationsUrl = organizationsUrl;
        }

        @Override
        public String toString() {
            return "Owner{" +
                    "gistsUrl='" + gistsUrl + '\'' +
                    ", reposUrl='" + reposUrl + '\'' +
                    ", login='" + login + '\'' +
                    ", type='" + type + '\'' +
                    ", url='" + url + '\'' +
                    ", avatarUrl='" + avatarUrl + '\'' +
                    ", id=" + id +
                    ", gravatarId='" + gravatarId + '\'' +
                    ", nodeId='" + nodeId + '\'' +
                    ", organizationsUrl='" + organizationsUrl + '\'' +
                    '}';
        }
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
