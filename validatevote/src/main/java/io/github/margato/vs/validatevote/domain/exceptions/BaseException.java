package io.github.margato.vs.validatevote.domain.exceptions;

public abstract class BaseException extends RuntimeException  {

    public BaseException(String reason) {
        super(reason);
    }

    public abstract String getReason();

}
