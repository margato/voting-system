package io.github.margato.vs.voting.domain.exceptions;

public class VotingIllegalStateException extends BaseException {
    private final static String REASON = "Cannot add candidates: Voting has already started";

    public VotingIllegalStateException() {
        super(REASON);
    }

    @Override
    public String getReason() {
        return REASON;
    }
}
