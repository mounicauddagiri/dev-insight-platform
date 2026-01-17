package com.example.insights.ingestion;

import org.springframework.stereotype.Service;

import com.example.insights.ingestion.dto.GitHubRepositoryDto;

@Service
public class GitHubIngestionService {
    
    private final GitHubClient client;

    public GitHubIngestionService(GitHubClient client){
        this.client = client;
    }

    public GitHubRepositoryDto[] fetchOrgRepositories(String organization) {
        return client.getRepositories(organization);
    }
}
