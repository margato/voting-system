package io.github.margato.vs.voting.boundaries.http.presenter.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@JsonPropertyOrder({"id", "name", "start_time", "end_time",  "active"})
public class VotingResponse {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("start_time")
    private LocalDateTime startTime;

    @JsonProperty("end_time")
    private LocalDateTime endTime;

    @JsonProperty("open")
    private boolean open;

    @JsonProperty("candidates")
    private List<CandidateResponse> candidates;
}
