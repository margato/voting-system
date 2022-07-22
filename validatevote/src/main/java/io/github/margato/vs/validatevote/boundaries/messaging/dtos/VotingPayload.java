package io.github.margato.vs.validatevote.boundaries.messaging.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
@Getter
public class VotingPayload {
    private String id;
    private String votingId;
    private String candidateId;
}
