package io.github.margato.vs.voting.configuration.spring;

import io.github.margato.vs.voting.boundaries.http.presenter.dtos.response.ErrorResponse;
import io.github.margato.vs.voting.domain.exceptions.VotingIllegalStateException;
import io.github.margato.vs.voting.domain.exceptions.BaseException;
import io.github.margato.vs.voting.domain.exceptions.VotingNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class RestControllerAdvice {

    @ExceptionHandler({VotingIllegalStateException.class})
    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorResponse businessLogicError(BaseException e) {
        return ErrorResponse.builder()
                .message(e.getReason())
                .build();
    }

    @ExceptionHandler({VotingNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorResponse notFound(BaseException e) {
        return ErrorResponse.builder()
                .message(e.getReason())
                .build();
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse defaultHandler(Exception e) {
        return ErrorResponse.builder()
                .message(e.getMessage())
                .build();
    }

}
