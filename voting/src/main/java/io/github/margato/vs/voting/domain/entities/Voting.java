package io.github.margato.vs.voting.domain.entities;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Getter
@Builder
public class Voting {
    private String id;
    private String name;
    private boolean open;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<Candidate> candidates;

    @Override
    public String toString() {
        return "Voting{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public boolean isOpen() {
        LocalDateTime now = LocalDateTime.now();
        boolean doesNotHaveMinimumCandidates = candidates.size() <= 1;
        return doesNotHaveMinimumCandidates || now.isBefore(startTime) || now.isAfter(endTime);
    }

    public List<Candidate> getCandidates() {
        candidates.sort(Comparator.comparing(Candidate::getVotes));
        candidates.sort(Collections.reverseOrder());
        return candidates;
    }

    public boolean canAddCandidate() {
        LocalDateTime now = LocalDateTime.now();
        return now.isBefore(endTime);
    }

    public boolean cannotAddCandidate() {
        return !canAddCandidate();
    }
}
