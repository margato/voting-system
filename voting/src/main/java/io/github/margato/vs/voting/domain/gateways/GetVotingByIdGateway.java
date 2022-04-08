package io.github.margato.vs.voting.domain.gateways;

import io.github.margato.vs.voting.domain.entities.Voting;

import java.util.Optional;

public interface GetVotingByIdGateway {
    Optional<Voting> findById(String id);

    boolean existsById(String votingId);
}
