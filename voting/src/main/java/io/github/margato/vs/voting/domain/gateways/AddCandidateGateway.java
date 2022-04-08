package io.github.margato.vs.voting.domain.gateways;

import io.github.margato.vs.voting.domain.entities.Candidate;

public interface AddCandidateGateway {
    Candidate add(String votingId, Candidate candidate);
}
