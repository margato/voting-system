package io.github.margato.vs.validatevote.domain.gateways;

import io.github.margato.vs.validatevote.domain.entities.Voting;
import io.github.margato.vs.validatevote.domain.exceptions.InvalidVotingException;

public interface GetVotingByIdGateway {
    Voting findById(String id) throws InvalidVotingException;
}
