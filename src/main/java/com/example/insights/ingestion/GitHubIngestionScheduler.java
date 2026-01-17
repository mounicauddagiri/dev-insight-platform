package com.example.insights.ingestion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class GitHubIngestionScheduler  {
    private static final Logger log = LoggerFactory.getLogger(GitHubIngestionScheduler.class);

    private final GitHubIngestionService service;

    public GitHubIngestionScheduler(GitHubIngestionService service) {
        this.service = service;
    }

    @Scheduled(fixedDelayString = "PT10M")
    public void ingest() {
        log.info("Running GitHub ingestion job...");
        var repos = service.fetchOrgRepositories("github");
        log.info("Fetched {} repositories", repos.length);
    }
}
