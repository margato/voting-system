package io.github.margato.vs.voting.domain.entities;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class Voting {
    private String id;
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean active;
    private List<Candidate> candidates;

    public boolean isClosed() {
        LocalDateTime now = LocalDateTime.now();
        boolean doesNotHaveMinimumCandidates = candidates.size() <= 1;
        return doesNotHaveMinimumCandidates || !active || now.isBefore(startTime) || now.isAfter(endTime);
    }

    public boolean canAddCandidate() {
        LocalDateTime now = LocalDateTime.now();
        return active && now.isBefore(endTime);
    }

    public boolean cannotAddCandidate() {
        return !canAddCandidate();
    }
}
