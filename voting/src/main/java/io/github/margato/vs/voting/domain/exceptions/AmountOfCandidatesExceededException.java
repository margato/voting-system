package io.github.margato.vs.voting.domain.exceptions;

public class AmountOfCandidatesExceededException extends BaseException {
    private final static String REASON = "Amount of candidates exceeded";

    public AmountOfCandidatesExceededException() {
        super(REASON);
    }

    @Override
    public String getReason() {
        return REASON;
    }
}
