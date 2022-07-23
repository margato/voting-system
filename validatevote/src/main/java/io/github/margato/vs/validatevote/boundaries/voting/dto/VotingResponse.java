package io.github.margato.vs.validatevote.boundaries.voting.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDateTime;
import java.util.List;

@Jacksonized
@Getter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class VotingResponse {
    private String id;

    @JsonProperty("start_time")
    private LocalDateTime startTime;

    @JsonProperty("end_time")
    private LocalDateTime endTime;

    private boolean open;
    private List<CandidateResponse> candidates;
}
