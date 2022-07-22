package io.github.margato.vs.validatevote.boundaries.voting.adapter;

import feign.FeignException;
import io.github.margato.vs.validatevote.boundaries.voting.dataprovider.VotingDataProvider;
import io.github.margato.vs.validatevote.boundaries.voting.dto.VotingWrapperResponse;
import io.github.margato.vs.validatevote.boundaries.voting.mapper.VotingResponseMapper;
import io.github.margato.vs.validatevote.domain.entities.Voting;
import io.github.margato.vs.validatevote.domain.exceptions.InvalidVotingException;
import io.github.margato.vs.validatevote.domain.gateways.GetVotingByIdGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class VotingRestAdapter implements GetVotingByIdGateway {
    private final VotingDataProvider votingDataProvider;
    private final VotingResponseMapper votingResponseMapper;

    @Override
//    @Cacheable(value = "Votings")
    public Voting findById(String id){
        try {
            ResponseEntity<VotingWrapperResponse> response = votingDataProvider.getVotingById(id);
            log.info("Voting retrieved by API: {}", response.getBody().getVoting().getId());
            return votingResponseMapper.toDomain(response.getBody().getVoting());
        } catch (FeignException.FeignClientException.BadRequest | NullPointerException e) {
            throw new InvalidVotingException();
        }
    }
}
