package io.github.margato.vs.receivevote.boundaries.http.presenter.controller;

import io.github.margato.vs.receivevote.boundaries.http.presenter.dtos.request.VoteRequest;
import io.github.margato.vs.receivevote.domain.usecases.AsyncVoteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/votings/{voting_id}/votes")
@RequiredArgsConstructor
public class VoteController {
    private final AsyncVoteUseCase asyncVoteUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void add(@PathVariable("voting_id") String votingId,
                                               @RequestBody VoteRequest voteRequest) {
        asyncVoteUseCase.vote(votingId, voteRequest.getCandidateId());
    }

}

