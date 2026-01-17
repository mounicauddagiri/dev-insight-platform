package com.example.insights.ingestion.mapper;

import com.example.insights.domain.Repository;
import com.example.insights.ingestion.dto.GitHubRepositoryDto;

public class GitHubRepositoryMapper {
    
    public static Repository toEntity(GitHubRepositoryDto dto){
        Repository repo = new Repository();
        repo.setName(dto.getName());
        repo.setHtmlUrl(dto.getHtmlUrl());
        repo.setDescription(dto.getDescription());

        return repo;
    }
}
