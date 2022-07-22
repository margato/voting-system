package io.github.margato.vs.validatevote.domain.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@ToString
public class Voting {
    private String id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean active;
    private List<Candidate> candidates;

    public boolean isClosed() {
        LocalDateTime now = LocalDateTime.now();
        return !active || now.isBefore(startTime) || now.isAfter(endTime);
    }

    public boolean doesNotHaveMinimumCandidates() {
        return candidates.size() <= 1;
    }

    public boolean hasCandidate(String candidateId) {
        return candidates
                .stream()
                .anyMatch(candidate -> candidate.getId().equals(candidateId));
    }
}
