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
    private boolean open;
    private List<Candidate> candidates;


    public boolean hasCandidate(String candidateId) {
        return candidates
                .stream()
                .anyMatch(candidate -> candidate.getId().equals(candidateId));
    }
}
