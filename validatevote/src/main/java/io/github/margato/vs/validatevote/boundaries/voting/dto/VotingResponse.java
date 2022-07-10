package io.github.margato.vs.validatevote.boundaries.voting.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDateTime;
import java.util.List;

@Jacksonized
@Getter
@Builder
public class VotingResponse {
    @JsonProperty("start_time")
    private LocalDateTime startTime;
    @JsonProperty("end_time")
    private LocalDateTime endTime;
    private boolean active;
    private List<CandidateResponse> candidates;
}