package io.github.margato.vs.voting.boundaries.http.presenter.mappers;

import io.github.margato.vs.voting.boundaries.http.presenter.dtos.request.VotingRequest;
import io.github.margato.vs.voting.domain.entities.Voting;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VotingRequestMapper {
    Voting toDomain(VotingRequest votingRequest);
}
