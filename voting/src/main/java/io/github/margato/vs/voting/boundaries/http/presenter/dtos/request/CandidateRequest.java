package io.github.margato.vs.voting.boundaries.http.presenter.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class CandidateRequest {
    @JsonProperty("name")
    private String name;

    @JsonProperty("image_url")
    private String imageUrl;
}
