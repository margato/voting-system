package io.github.margato.vs.voting.domain.entities;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Getter
@Builder
public class Voting {
    private String id;
    private String imageUrl;
    private String name;
    private boolean open;
    private int totalVotes;
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
        boolean haveMinimumCandidates = candidates.size() > 1;
        return haveMinimumCandidates && now.isAfter(startTime) && now.isBefore(endTime);
    }

    public int getTotalVotes() {
        return candidates.stream()
                .map(Candidate::getVotes)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public List<Candidate> getCandidates() {
        Collections.sort(candidates);
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
