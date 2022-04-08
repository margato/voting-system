CREATE DATABASE IF NOT EXISTS voting;
USE voting;

CREATE TABLE IF NOT EXISTS votings
(
    id             BINARY(16) PRIMARY KEY,
    start_time     TIMESTAMP,
    end_time       TIMESTAMP,
    min_candidates INT UNSIGNED,
    max_candidates INT UNSIGNED,
    active         BOOLEAN,
    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at     DATETIME  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS candidates
(
    id         BINARY(16) PRIMARY KEY,
    name       VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    voting_id  BINARY(16) NOT NULL,
    FOREIGN KEY (voting_id) REFERENCES votings (id)
);