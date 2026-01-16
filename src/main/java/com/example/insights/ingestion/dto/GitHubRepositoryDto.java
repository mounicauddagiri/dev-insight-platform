package com.example.insights.ingestion.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GitHubRepositoryDto {
    private String name;

    @JsonProperty("html_url")
    private String htmlUrl;

    private String description;

    public GitHubRepositoryDto(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }   

    public String getHtmlUrl() {
        return htmlUrl;
    }  

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }   

    public String getDescription() {
        return description;
    }   

    public void setDescription(String description) {
        this.description = description;
    }  
    
}
