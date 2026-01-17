CREATE TABLE repositories (
  id BIGSERIAL PRIMARY KEY,
  name TEXT NOT NULL,
  html_url TEXT NOT NULL,
  description TEXT
);