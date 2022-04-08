package io.github.margato.vs.voting.boundaries.http.presenter.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BaseResponse<T> {

    @JsonProperty("data")
    private T data;

}
