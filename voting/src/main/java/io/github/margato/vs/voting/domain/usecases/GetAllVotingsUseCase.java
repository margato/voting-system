package io.github.margato.vs.voting.domain.usecases;

import io.github.margato.vs.voting.domain.entities.Voting;
import io.github.margato.vs.voting.domain.gateways.GetAllVotingsGateway;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GetAllVotingsUseCase {
    private final GetAllVotingsGateway getAllVotingsGateway;

    public List<Voting> getAll() {
        return getAllVotingsGateway.findAll();
    }
}
