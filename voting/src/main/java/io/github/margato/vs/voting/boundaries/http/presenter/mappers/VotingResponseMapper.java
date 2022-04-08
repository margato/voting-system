package io.github.margato.vs.voting.boundaries.http.presenter.mappers;

import io.github.margato.vs.voting.boundaries.http.presenter.dtos.response.VotingResponse;
import io.github.margato.vs.voting.domain.entities.Voting;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = CandidateResponseMapper.class)
public interface VotingResponseMapper {
    VotingResponse fromDomain(Voting voting);
}
