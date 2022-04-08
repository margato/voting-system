package io.github.margato.vs.voting.boundaries.http.presenter.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@JsonPropertyOrder({"id", "start_time", "end_time", "min_candidates", "max_candidates", "active"})
public class VotingResponse {
    @JsonProperty("id")
    private String id;

    @JsonProperty("start_time")
    private LocalDateTime startTime;

    @JsonProperty("end_time")
    private LocalDateTime endTime;

    @JsonProperty("active")
    private boolean active;

    @JsonProperty("min_candidates")
    private int minCandidates;

    @JsonProperty("max_candidates")
    private int maxCandidates;

    @JsonProperty("candidates")
    private List<CandidateResponse> candidates;
}
