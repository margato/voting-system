package io.github.margato.vs.voting.boundaries.http.presenter.mappers;

import io.github.margato.vs.voting.boundaries.http.presenter.dtos.response.CandidateResponse;
import io.github.margato.vs.voting.domain.entities.Candidate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = CandidateResponseMapper.class)
public interface CandidateResponseMapper {
    CandidateResponse fromDomain(Candidate candidate);
}
