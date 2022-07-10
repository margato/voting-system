package io.github.margato.vs.validatevote.boundaries.voting.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Getter
@Builder
public class VotingWrapperResponse {
    @JsonProperty("data")
    private VotingResponse voting;
}
