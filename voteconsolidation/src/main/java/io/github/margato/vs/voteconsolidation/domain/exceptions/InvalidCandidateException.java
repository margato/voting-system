package io.github.margato.vs.voteconsolidation.domain.exceptions;

public class InvalidCandidateException extends BaseException {
    private static String REASON = "Voting is not valid";

    public InvalidCandidateException() {
        super(REASON);
    }

    @Override
    public String getReason() {
        return "Voting is not valid";
    }
}
