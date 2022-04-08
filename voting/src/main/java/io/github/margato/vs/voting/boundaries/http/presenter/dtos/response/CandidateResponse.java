package io.github.margato.vs.voting.boundaries.http.presenter.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonPropertyOrder({"id", "name"})
public class CandidateResponse {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;
}
