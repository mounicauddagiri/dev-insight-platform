package com.example.insights.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryJpaRepository extends JpaRepository<Repository, Long> {
    Optional<Repository> findByName(String name);
}
