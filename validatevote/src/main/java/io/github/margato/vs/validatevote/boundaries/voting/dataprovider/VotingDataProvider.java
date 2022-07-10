package io.github.margato.vs.validatevote.boundaries.voting.dataprovider;

import io.github.margato.vs.validatevote.boundaries.voting.dto.VotingWrapperResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="voting-api", url="${voting-api.url}${voting-api.path}")
public interface VotingDataProvider {

    @GetMapping("/{voting_id}")
    ResponseEntity<VotingWrapperResponse> getVotingById(@PathVariable("voting_id") String id);

}
