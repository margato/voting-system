package io.github.margato.vs.voting.domain.usecases;

import io.github.margato.vs.voting.domain.entities.Voting;
import io.github.margato.vs.voting.domain.gateways.CreateVotingGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateVotingUseCase {
    private final CreateVotingGateway createVotingGateway;

    public Voting create(Voting voting) {
        return createVotingGateway.create(voting);
    }
}
