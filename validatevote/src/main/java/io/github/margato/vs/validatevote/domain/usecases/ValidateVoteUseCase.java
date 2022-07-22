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
            log.error("Voting {} already closed", voting.getId());
            return;
        }

        if (voting.hasMinimumCandidates()) {
            log.error("Voting {} does not have minimum candidates", voting.getId());
            return;
        }

        if (!voting.hasCandidate(candidateId)) {
            log.error("Voting {} does not have candidate {}", voting.getId(), candidateId);
            return;
        }

        log.info("Vote for {} in {} is valid", candidateId, votingId);
        sendVoteGateway.send(
                Vote.builder()
                        .votingId(votingId)
                        .candidateId(candidateId)
                        .build()
        );
    }
}
