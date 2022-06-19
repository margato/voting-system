package io.github.margato.vs.validatevote.domain.entities;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class Voting {
    private String id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean active;
    private int maxCandidates;
    private int minCandidates;
    private List<Candidate> candidates;

    public boolean isClosed() {
        LocalDateTime now = LocalDateTime.now();
        return !active || now.isBefore(startTime) || now.isAfter(endTime);
    }

    public boolean canAddCandidate() {
        LocalDateTime now = LocalDateTime.now();
        boolean validTime = active && now.isBefore(startTime);
        return validTime && candidates.size() < maxCandidates;
    }

    public boolean hasCandidate(String candidateId) {
        return candidates
                .stream()
                .anyMatch(candidate -> candidate.getId().equals(candidateId));
    }
}
