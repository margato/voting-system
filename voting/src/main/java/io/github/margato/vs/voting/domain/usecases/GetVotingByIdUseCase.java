package io.github.margato.vs.voting.domain.usecases;

import io.github.margato.vs.voting.domain.entities.Voting;
import io.github.margato.vs.voting.domain.exceptions.VotingNotFoundException;
import io.github.margato.vs.voting.domain.gateways.GetVotingByIdGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetVotingByIdUseCase {
    private final GetVotingByIdGateway getVotingByIdGateway;

    public Voting get(String id) {
        return getVotingByIdGateway.findById(id)
                .orElseThrow(VotingNotFoundException::new);
    }
}
