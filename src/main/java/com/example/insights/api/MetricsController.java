package com.example.insights.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.insights.domain.RepositoryJpaRepository;

@RestController
@RequestMapping("/api/v1/metrics")
public class MetricsController {
    private final RepositoryJpaRepository repository;

    public MetricsController(RepositoryJpaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/repositories/count")
    public long getRepositoryCount() {
        return repository.count();
    }
}
