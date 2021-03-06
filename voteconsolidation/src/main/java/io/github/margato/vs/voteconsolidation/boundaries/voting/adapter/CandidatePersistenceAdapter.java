package io.github.margato.vs.voteconsolidation.boundaries.voting.adapter;

import io.github.margato.vs.voteconsolidation.boundaries.voting.repository.CandidateRepository;
import io.github.margato.vs.voteconsolidation.domain.exceptions.InvalidCandidateException;
import io.github.margato.vs.voteconsolidation.domain.gateways.UpdateVoteCountGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CandidatePersistenceAdapter implements UpdateVoteCountGateway {
    private final CandidateRepository candidateRepository;

    @Override
    public void update(String candidateId, int votesReceived) throws InvalidCandidateException {
        try {
            candidateRepository.updateCount(UUID.fromString(candidateId), votesReceived);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
