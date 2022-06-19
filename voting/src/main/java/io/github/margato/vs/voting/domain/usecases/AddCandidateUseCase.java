package io.github.margato.vs.voting.domain.usecases;

import io.github.margato.vs.voting.domain.entities.Candidate;
import io.github.margato.vs.voting.domain.entities.Voting;
import io.github.margato.vs.voting.domain.exceptions.VotingIllegalStateException;
import io.github.margato.vs.voting.domain.exceptions.VotingNotFoundException;
import io.github.margato.vs.voting.domain.gateways.GetVotingByIdGateway;
import io.github.margato.vs.voting.domain.gateways.AddCandidateGateway;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class AddCandidateUseCase {
    private final AddCandidateGateway addCandidateGateway;
    private final GetVotingByIdGateway getVotingByIdGateway;

    public Candidate add(String votingId, Candidate candidate) {
        Optional<Voting> votingOptional = getVotingByIdGateway.findById(votingId);
        if (votingOptional.isEmpty()) {
            throw new VotingNotFoundException();
        }

        Voting voting = votingOptional.get();

        if (voting.cannotAddCandidate()) {
            throw new VotingIllegalStateException();
        }

        return addCandidateGateway.add(votingId, candidate);
    }

}
