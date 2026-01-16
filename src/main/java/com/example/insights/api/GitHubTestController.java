package com.example.insights.api;

import org.springframework.web.bind.annotation.*;

import com.example.insights.ingestion.GitHubClient;

@RestController
@RequestMapping("/api/v1/github")
public class GitHubTestController {

    private final GitHubClient client;

    public GitHubTestController(GitHubClient client) {
        this.client = client;
    }

    @GetMapping("/orgs/{org}/repos")
    public String repos(@PathVariable String org) {
        return client.getRepositories(org).getBody();
    }
}
