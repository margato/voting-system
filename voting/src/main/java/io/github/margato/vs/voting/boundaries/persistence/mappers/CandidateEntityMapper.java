package io.github.margato.vs.voting.boundaries.persistence.mappers;

import io.github.margato.vs.voting.boundaries.persistence.entities.CandidateEntity;
import io.github.margato.vs.voting.domain.entities.Candidate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {TypeMapper.class})
public interface CandidateEntityMapper {

    Candidate toDomain(CandidateEntity CandidateEntity);
    @Mapping(source = "votingId", target = "voting.id")
    CandidateEntity fromDomain(Candidate Candidate, String votingId);

    default List<Candidate> toDomainList(List<CandidateEntity> votingEntities) {
        return votingEntities == null
                ? new ArrayList<>()
                : votingEntities.stream().map(this::toDomain).collect(Collectors.toList());
    }
}
