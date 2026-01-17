package com.example.insights.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "repositories")
public class Repository {

    @Id
    private Long id;

    private String name;

    private String htmlUrl;

    private String description;

    // getters & setters

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
       return name;
    }   

    public String getHtmlUrl() {
        return htmlUrl;  
    }

    public String getDescription() {
        return description;
    }

}
