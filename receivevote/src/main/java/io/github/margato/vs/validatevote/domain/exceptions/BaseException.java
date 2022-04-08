package io.github.margato.vs.receivevote.domain.exceptions;

public abstract class BaseException extends RuntimeException  {

    public BaseException(String reason) {
        super(reason);
    }

    public abstract String getReason();

}
