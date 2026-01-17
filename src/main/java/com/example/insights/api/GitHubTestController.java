package com.example.insights.api;

import org.springframework.web.bind.annotation.*;

import com.example.insights.ingestion.GitHubClient;
import com.example.insights.ingestion.GitHubIngestionScheduler;
import com.example.insights.ingestion.GitHubIngestionService;
import com.example.insights.ingestion.dto.GitHubRepositoryDto;

@RestController
@RequestMapping("/api/v1/github")
public class GitHubTestController {

    
    private final GitHubIngestionService service;

    public GitHubTestController(GitHubIngestionService service) {
        this.service = service;
    }

    @GetMapping("/orgs/{org}/repos")
    public GitHubRepositoryDto[] repos(@PathVariable String org) {
       return service.fetchOrgRepositories(org);
    }
}