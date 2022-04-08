package io.github.margato.vs.voting.boundaries.persistence.adapters;

import io.github.margato.vs.voting.boundaries.persistence.entities.CandidateEntity;
import io.github.margato.vs.voting.boundaries.persistence.mappers.CandidateEntityMapper;
import io.github.margato.vs.voting.boundaries.persistence.repository.CandidateRepository;
import io.github.margato.vs.voting.domain.entities.Candidate;
import io.github.margato.vs.voting.domain.gateways.AddCandidateGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CandidatePersistenceAdapter implements AddCandidateGateway {
    private final CandidateRepository candidateRepository;
    private final CandidateEntityMapper candidateEntityMapper;

    @Override
    public Candidate add(String votingId, Candidate candidate) {
        CandidateEntity candidateEntity = candidateRepository.save(candidateEntityMapper.fromDomain(candidate, votingId));
        return candidateEntityMapper.toDomain(candidateEntity);
    }
}
