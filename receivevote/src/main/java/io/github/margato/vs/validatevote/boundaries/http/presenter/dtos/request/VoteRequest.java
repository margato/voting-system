package io.github.margato.vs.receivevote.boundaries.http.presenter.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Getter
@Builder
public class VoteRequest {
    @JsonProperty("candidate_id")
    private String candidateId;
}
