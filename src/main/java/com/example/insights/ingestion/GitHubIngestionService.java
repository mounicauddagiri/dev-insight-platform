package com.example.insights.ingestion;

import org.springframework.stereotype.Service;

import com.example.insights.domain.RepositoryJpaRepository;
import com.example.insights.ingestion.dto.GitHubRepositoryDto;
import com.example.insights.ingestion.mapper.GitHubRepositoryMapper;

import jakarta.transaction.Transactional;

@Service
public class GitHubIngestionService {
    
    private final GitHubClient client;
    private final RepositoryJpaRepository repository;

    public GitHubIngestionService(
            GitHubClient client, 
            RepositoryJpaRepository repository)  {
        this.client = client;
        this.repository = repository;
    }

    @Transactional
    public int ingestOrgRepositories(String organization) {
        var repos = client.getRepositories(organization);

        int saved  = 0;

        for(var dto: repos){
            boolean exists = repository.findByName(dto.getName()).isPresent();
            if(exists) continue;

            var entity = GitHubRepositoryMapper.toEntity(dto);
            repository.save(entity);
            saved++;
        }
        return saved;
    }

    public GitHubRepositoryDto[] fetchOrgRepositories(String organization) {
        return client.getRepositories(organization);
    }
}
