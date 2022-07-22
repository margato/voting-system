package io.github.margato.vs.voting.boundaries.persistence.mappers;

import io.github.margato.vs.voting.boundaries.persistence.entities.VotingEntity;
import io.github.margato.vs.voting.domain.entities.Voting;
import org.mapstruct.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring", uses = {CandidateEntityMapper.class, TypeMapper.class}, imports = ArrayList.class)
public interface VotingEntityMapper {

    Voting toDomain(VotingEntity votingEntity);
    VotingEntity fromDomain(Voting voting);

    default Optional<Voting> toDomain(Optional<VotingEntity> optionalVotingEntity) {
        return optionalVotingEntity.isEmpty()
                ? Optional.empty()
                : Optional.of(toDomain(optionalVotingEntity.get()));
    }

    List<Voting> toDomain(Iterable<VotingEntity> entities);
}
