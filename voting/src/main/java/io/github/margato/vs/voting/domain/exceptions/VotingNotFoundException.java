package io.github.margato.vs.voting.domain.exceptions;

public class VotingNotFoundException extends BaseException {
    private final static String REASON = "Voting not found";

    public VotingNotFoundException() {
        super(REASON);
    }

    @Override
    public String getReason() {
        return REASON;
    }
}
