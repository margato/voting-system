package io.github.margato.vs.validatevote.domain.exceptions;

public class InvalidVotingException extends BaseException {
    private static String REASON = "Voting is not valid";

    public InvalidVotingException() {
        super(REASON);
    }

    @Override
    public String getReason() {
        return "Voting is not valid";
    }
}
