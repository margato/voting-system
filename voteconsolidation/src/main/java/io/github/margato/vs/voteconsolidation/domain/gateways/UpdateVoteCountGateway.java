package io.github.margato.vs.voteconsolidation.domain.gateways;

import io.github.margato.vs.voteconsolidation.domain.exceptions.InvalidCandidateException;

public interface UpdateVoteCountGateway {
    void update(String candidateId, int votesReceived) throws InvalidCandidateException;
}
