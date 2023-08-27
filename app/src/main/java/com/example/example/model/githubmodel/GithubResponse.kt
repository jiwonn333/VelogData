package com.example.example.model.githubmodel

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class GithubResponse : Serializable {
    @SerializedName("id")
    var id = 0

    @SerializedName("full_name")
    val fullName: String? = null

    //
    @SerializedName("description")
    var description: String? = null

    @SerializedName("owner")
    var owner: Owner? = null

    inner class Owner : Serializable {
        @SerializedName("gists_url")
        var gistsUrl: String? = null

        @SerializedName("repos_url")
        var reposUrl: String? = null

        @SerializedName("login")
        var login: String? = null

        @SerializedName("type")
        var type: String? = null

        @SerializedName("url")
        var url: String? = null

        @SerializedName("avatar_url")
        var avatarUrl: String? = null

        @SerializedName("id")
        var id = 0

        @SerializedName("gravatar_id")
        var gravatarId: String? = null

        @SerializedName("node_id")
        var nodeId: String? = null

        @SerializedName("organizations_url")
        var organizationsUrl: String? = null
        override fun toString(): String {
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
                    '}'
        }
    } //
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