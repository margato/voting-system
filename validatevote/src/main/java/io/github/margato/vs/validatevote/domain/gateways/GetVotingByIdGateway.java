package io.github.margato.vs.validatevote.domain.gateways;

import io.github.margato.vs.validatevote.domain.entities.Voting;

public interface GetVotingByIdGateway {
    Voting findById(String id);
}
