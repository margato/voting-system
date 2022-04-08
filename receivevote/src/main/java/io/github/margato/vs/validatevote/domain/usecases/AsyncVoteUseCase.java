package io.github.margato.vs.receivevote.domain.usecases;

import io.github.margato.vs.receivevote.domain.entities.Vote;
import io.github.margato.vs.receivevote.domain.gateways.SendMessageGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AsyncVoteUseCase {
    private final SendMessageGateway sendVoteGateway;

    public void vote(String votingId, String candidateId) {
        sendVoteGateway.send(
                Vote.builder()
                        .votingId(votingId)
                        .candidateId(candidateId)
                        .build()
        );
    }
}
