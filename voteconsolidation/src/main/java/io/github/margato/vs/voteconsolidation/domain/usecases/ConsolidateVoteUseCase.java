package io.github.margato.vs.voteconsolidation.domain.usecases;

import io.github.margato.vs.voteconsolidation.domain.entities.Vote;
import io.github.margato.vs.voteconsolidation.domain.gateways.UpdateVoteCountGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Log4j2
public class ConsolidateVoteUseCase {
    private final UpdateVoteCountGateway updateVoteCountGateway;

    public void consolidate(List<Vote> votes) {
        Map<String, Integer> votesPerCandidate = new HashMap<>();

        votes.forEach(vote -> {
            String candidateId = vote.getCandidateId();
            votesPerCandidate.putIfAbsent(candidateId, 0);
            votesPerCandidate.put(candidateId, votesPerCandidate.get(candidateId) + 1);
        });

        log.info(votesPerCandidate);

        votesPerCandidate.forEach(updateVoteCountGateway::update);
    }
}
