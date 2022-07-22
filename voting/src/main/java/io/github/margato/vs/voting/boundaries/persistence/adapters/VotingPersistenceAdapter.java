package io.github.margato.vs.voting.boundaries.persistence.adapters;

import io.github.margato.vs.voting.boundaries.persistence.entities.VotingEntity;
import io.github.margato.vs.voting.boundaries.persistence.mappers.VotingEntityMapper;
import io.github.margato.vs.voting.boundaries.persistence.repository.VotingRepository;
import io.github.margato.vs.voting.domain.entities.Voting;
import io.github.margato.vs.voting.domain.gateways.CreateVotingGateway;
import io.github.margato.vs.voting.domain.gateways.GetAllVotingsGateway;
import io.github.margato.vs.voting.domain.gateways.GetVotingByIdGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class VotingPersistenceAdapter implements CreateVotingGateway, GetVotingByIdGateway, GetAllVotingsGateway {
    private final VotingRepository votingRepository;
    private final VotingEntityMapper votingEntityMapper;

    @Override
    public Voting create(Voting voting) {
        VotingEntity votingEntity = votingEntityMapper.fromDomain(voting);
        votingEntity.setActive(true);
        return votingEntityMapper.toDomain(votingRepository.save(votingEntity));
    }

    @Override
    public Optional<Voting> findById(String id) {
        return votingEntityMapper.toDomain(votingRepository.findById(UUID.fromString(id)));
    }

    @Override
    public boolean existsById(String votingId) {
        return votingRepository.existsById(UUID.fromString(votingId));
    }

    @Override
    public List<Voting> findAll() {
        return votingEntityMapper.toDomain(votingRepository.findAll());
    }
}
