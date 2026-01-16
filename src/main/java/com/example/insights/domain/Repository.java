package com.example.insights.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "repositories")
public class Repository {

    @Id
    private Long id;

    private String name;

    private String htmlUrl;

    private String description;

    // getters & setters
}
