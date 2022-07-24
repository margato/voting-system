package io.github.margato.vs.voting.boundaries.http.presenter.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;
import java.time.LocalDateTime;

@Jacksonized
@Builder
@Getter
public class VotingRequest {
    @JsonProperty("start_time")
    private LocalDateTime startTime;

    @JsonProperty("end_time")
    private LocalDateTime endTime;

    @JsonProperty("image_url")
    private String imageUrl;

    private String name;
}
