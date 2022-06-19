package io.github.margato.vs.validatevote.domain.entities;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class Vote {
    private final String id = UUID.randomUUID().toString();
    private String votingId;
    private String candidateId;
}
