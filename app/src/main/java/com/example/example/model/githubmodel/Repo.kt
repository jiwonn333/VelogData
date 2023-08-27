package com.example.example.model.githubmodel

import java.io.Serializable

class Repo(var name: String, var description: String?, var profileUrl: String?) : Serializable {

    override fun toString(): String {
        return "Repo{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", profileUrl='" + profileUrl + '\'' +
                '}'
    }
}