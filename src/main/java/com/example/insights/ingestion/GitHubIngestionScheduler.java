package com.example.insights.ingestion;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class GitHubIngestionScheduler  {
    @Scheduled(fixedDelayString = "PT10M")
    public void ingest() {
        System.out.println("Running GitHub ingestion job...");
    }
}
