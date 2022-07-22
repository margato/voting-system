package io.github.margato.vs.voting.domain.gateways;

import io.github.margato.vs.voting.domain.entities.Voting;

import java.util.List;
import java.util.Optional;

public interface GetAllVotingsGateway {
    List<Voting> findAll();
}
