package io.github.margato.vs.receivevote.boundaries.messaging.exceptions;

import io.github.margato.vs.receivevote.domain.exceptions.BaseException;

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
