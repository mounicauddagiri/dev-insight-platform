package com.example.insights.ingestion;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GitHubClient {
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${github.api.base-url:https://api.github.com}")
    private String baseUrl;

    @Value("${github.api.token:}")
    private String token;

    public ResponseEntity<String> getRepositories(String org){
        HttpHeaders headers = new HttpHeaders();

        headers.set("Accept", "application/vnd.github+json");

        if (!token.isBlank()) {
            headers.setBearerAuth(token);
        }

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(
            baseUrl + "/orgs/" + org + "/repos",
            HttpMethod.GET,
            entity,
            String.class
        );
    }
}
