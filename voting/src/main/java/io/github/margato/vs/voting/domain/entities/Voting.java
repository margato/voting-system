package io.github.margato.vs.voting.domain.entities;

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
}
