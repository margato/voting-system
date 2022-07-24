package io.github.margato.vs.voting.domain.usecases;

import io.github.margato.vs.voting.domain.gateways.RemoveVotingByIdGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RemoveVotingByIdUseCase {
    private final RemoveVotingByIdGateway removeVotingByIdGateway;

    public void remove(String id) {
        removeVotingByIdGateway.remove(id);
    }
}
