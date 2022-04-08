package io.github.margato.vs.voting.boundaries.http.presenter.mappers;

import io.github.margato.vs.voting.boundaries.http.presenter.dtos.request.CandidateRequest;
import io.github.margato.vs.voting.domain.entities.Candidate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CandidateRequestMapper {
    Candidate toDomain(CandidateRequest votingRequest);
}
