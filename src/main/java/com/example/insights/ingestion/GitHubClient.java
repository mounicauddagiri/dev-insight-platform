package com.example.insights.ingestion;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.insights.ingestion.dto.GitHubRepositoryDto;

@Component
public class GitHubClient {
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${github.api.base-url:https://api.github.com}")
    private String baseUrl;

    @Value("${github.api.token:}")
    private String token;

    public GitHubRepositoryDto[] getRepositories(String org){
        HttpHeaders headers = new HttpHeaders();

        headers.set("Accept", "application/vnd.github+json");

        if (!token.isBlank()) {
            headers.setBearerAuth(token);
        }

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<GitHubRepositoryDto[]> response = restTemplate.exchange(
            baseUrl + "/orgs/" + org + "/repos",
            HttpMethod.GET,
            entity,
            GitHubRepositoryDto[].class
        );

        handleRateLimiting(response.getHeaders());

        return response.getBody();
    }

    private void handleRateLimiting(HttpHeaders headers) {
        var remaining = headers.getFirst("X-RateLimit-Remaining");
        var reset = headers.getFirst("X-RateLimit-Reset");

        if (remaining != null && Integer.parseInt(remaining) < 10) {
            throw new GitHubRateLimitException(
                "GitHub rate limit nearly exhausted. Resets at epoch " + reset
            );
        }
    }
}
