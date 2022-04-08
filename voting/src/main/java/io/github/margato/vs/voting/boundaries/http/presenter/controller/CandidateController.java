package io.github.margato.vs.voting.boundaries.http.presenter.controller;

import io.github.margato.vs.voting.boundaries.http.presenter.dtos.request.CandidateRequest;
import io.github.margato.vs.voting.boundaries.http.presenter.dtos.response.BaseResponse;
import io.github.margato.vs.voting.boundaries.http.presenter.dtos.response.CandidateResponse;
import io.github.margato.vs.voting.boundaries.http.presenter.mappers.CandidateRequestMapper;
import io.github.margato.vs.voting.boundaries.http.presenter.mappers.CandidateResponseMapper;
import io.github.margato.vs.voting.domain.entities.Candidate;
import io.github.margato.vs.voting.domain.usecases.AddCandidateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/votings/{voting_id}/candidates")
@RequiredArgsConstructor
public class CandidateController {
    private final AddCandidateUseCase addCandidateUseCase;
    private final CandidateRequestMapper candidateRequestMapper;
    private final CandidateResponseMapper candidateResponseMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponse<CandidateResponse> add(@PathVariable("voting_id") String votingId,
                                               @RequestBody CandidateRequest candidateRequest) {
        Candidate candidate = addCandidateUseCase.add(votingId, candidateRequestMapper.toDomain(candidateRequest));
        return new BaseResponse<>(candidateResponseMapper.fromDomain(candidate));
    }

}

