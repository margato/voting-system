package io.github.margato.vs.validatevote.domain.usecases;

import io.github.margato.vs.validatevote.domain.entities.Vote;
import io.github.margato.vs.validatevote.domain.entities.Voting;
import io.github.margato.vs.validatevote.domain.gateways.GetVotingByIdGateway;
import io.github.margato.vs.validatevote.domain.gateways.SendMessageGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Log4j2
public class ValidateVoteUseCase {
    private final SendMessageGateway sendVoteGateway;
    private final GetVotingByIdGateway getVotingByIdGateway;

    public void validate(String votingId, String candidateId) {
        Voting voting = getVotingByIdGateway.findById(votingId);
        if (voting.isClosed()) {
            log.info("Voting {} already closed", voting);
            return;
        }

        if (!voting.hasCandidate(candidateId)) {
            log.info("Voting {} does not have candidate {}", voting, candidateId);
            return;
        }

        sendVoteGateway.send(
                Vote.builder()
                        .votingId(votingId)
                        .candidateId(candidateId)
                        .build()
        );
    }
}