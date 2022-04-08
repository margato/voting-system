package io.github.margato.vs.voting.domain.gateways;

import io.github.margato.vs.voting.domain.entities.Voting;

public interface CreateVotingGateway {
    Voting create(Voting voting);
}
