package com.example.insights.ingestion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class GitHubIngestionScheduler  {
    private static final Logger log = LoggerFactory.getLogger(GitHubIngestionScheduler.class);

    private final GitHubClient client;

    public GitHubIngestionScheduler(GitHubClient client) {
        this.client = client;
    }

    @Scheduled(fixedDelayString = "PT10M")
    public void ingest() {
        log.info("Running GitHub ingestion job...");
        try {
            var repos = client.getRepositories("github");
            log.info("Fetched {} repositories", repos.length);
        } catch (Exception e) {
            log.error("Failed to fetch repositories", e);
        }
    }
}
