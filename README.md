# dev-insight-platform
# GitHub Developer Insights Platform

A backend-heavy internal platform that aggregates GitHub CI/CD and repository data into stable, versioned APIs for engineering visibility and developer tooling.

## Problem
Engineering teams often rely directly on GitHub APIs or ad-hoc scripts to understand build health, failures, and trends. This leads to duplicated logic, unstable integrations, and poor scalability.

This project demonstrates how to design a centralized backend service that:
- Ingests GitHub CI data reliably
- Aggregates metrics server-side
- Exposes clean, versioned APIs for internal consumers
- Emphasizes API design, scalability, and developer experience

## Target Users
- Platform / Dev Productivity teams
- Backend services consuming engineering metrics
- Internal dashboards and reporting tools

## Architecture

- Spring Boot 3 / Java 17
- Layered architecture (API → Service → Ingestion → Domain)
- Scheduled ingestion jobs
- GitHub REST API integration
- PostgreSQL (Flyway-managed migrations)

## Future Work

- Persist ingestion results
- Rate-limit handling & backoff
- Async ingestion via queues
- Repository metrics aggregation

## Why this project

This project simulates a backend ingestion platform similar to systems used
by developer tooling companies to aggregate repository metadata, apply
rate-limit-aware ingestion, and persist data using migration-driven schemas.