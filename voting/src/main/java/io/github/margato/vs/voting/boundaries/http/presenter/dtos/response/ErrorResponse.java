package io.github.margato.vs.voting.boundaries.http.presenter.dtos.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponse {
    private String message;
}
