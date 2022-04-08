package io.github.margato.vs.voting.boundaries.http.presenter.controller;

import io.github.margato.vs.voting.boundaries.http.presenter.dtos.request.VotingRequest;
import io.github.margato.vs.voting.boundaries.http.presenter.dtos.response.BaseResponse;
import io.github.margato.vs.voting.boundaries.http.presenter.dtos.response.VotingResponse;
import io.github.margato.vs.voting.boundaries.http.presenter.mappers.VotingRequestMapper;
import io.github.margato.vs.voting.boundaries.http.presenter.mappers.VotingResponseMapper;
import io.github.margato.vs.voting.domain.entities.Voting;
import io.github.margato.vs.voting.domain.usecases.CreateVotingUseCase;
import io.github.margato.vs.voting.domain.usecases.GetVotingByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/votings"})
@RequiredArgsConstructor
public class VotingController {
    private final CreateVotingUseCase createVotingUseCase;
    private final GetVotingByIdUseCase getVotingByIdUseCase;
    private final VotingRequestMapper votingRequestMapper;
    private final VotingResponseMapper votingResponseMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponse<VotingResponse> create(@RequestBody VotingRequest votingRequest) {
        Voting voting = this.createVotingUseCase.create(this.votingRequestMapper.toDomain(votingRequest));
        return new BaseResponse(this.votingResponseMapper.fromDomain(voting));
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse<VotingResponse> get(@PathVariable(name = "id") String id) {
        Voting voting = this.getVotingByIdUseCase.get(id);
        return new BaseResponse(this.votingResponseMapper.fromDomain(voting));
    }
}
