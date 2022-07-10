package io.github.margato.vs.validatevote.boundaries.voting.mapper;

import io.github.margato.vs.validatevote.boundaries.voting.dto.VotingResponse;
import io.github.margato.vs.validatevote.domain.entities.Voting;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VotingResponseMapper {

    Voting toDomain(VotingResponse response);

}
