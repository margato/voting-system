package io.github.margato.vs.voting.boundaries.http.presenter.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonPropertyOrder({"id", "name", "image_url"})
public class CandidateResponse {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("votes")
    private int votes;

    @JsonProperty("image_url")
    private String imageUrl;
}
