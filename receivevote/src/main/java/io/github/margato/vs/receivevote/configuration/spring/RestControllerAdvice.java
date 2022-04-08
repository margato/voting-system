package io.github.margato.vs.receivevote.configuration.spring;

import io.github.margato.vs.receivevote.boundaries.http.presenter.dtos.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class RestControllerAdvice {

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse defaultHandler(Exception e) {
        return ErrorResponse.builder()
                .message(e.getMessage())
                .build();
    }

}
