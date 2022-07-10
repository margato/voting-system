package io.github.margato.vs.validatevote.boundaries.voting.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
@Getter
public class CandidateResponse {
    private String id;
    private String name;
}
