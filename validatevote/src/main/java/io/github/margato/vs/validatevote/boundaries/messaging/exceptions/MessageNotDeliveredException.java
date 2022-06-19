package io.github.margato.vs.validatevote.boundaries.messaging.exceptions;

import io.github.margato.vs.validatevote.domain.exceptions.BaseException;

public class MessageNotDeliveredException extends BaseException {

    private final static String REASON = "Message could not be delivered to topic";

    public MessageNotDeliveredException() {
        super(REASON);
    }

    @Override
    public String getReason() {
        return REASON;
    }
}
