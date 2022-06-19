package io.github.margato.vs.validatevote.boundaries.voting;

import io.github.margato.vs.validatevote.domain.entities.Voting;
import io.github.margato.vs.validatevote.domain.gateways.GetVotingByIdGateway;
import org.springframework.stereotype.Service;

@Service
public class VotingRestService implements GetVotingByIdGateway {
    @Override
    public Voting findById(String id) {
        return null;
    }
}
