package io.github.margato.vs.receivevote.boundaries.http.presenter.controller;

import io.github.margato.vs.receivevote.domain.usecases.AsyncVoteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/votings/{voting_id}")
@RequiredArgsConstructor
public class VoteController {
    private final AsyncVoteUseCase asyncVoteUseCase;

    @PostMapping("/{candidate_id}/votes")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void add(@PathVariable("voting_id") String votingId,
                    @PathVariable("candidate_id") String candidateId) {
        asyncVoteUseCase.vote(votingId, candidateId);
    }

}

