package io.github.margato.vs.validatevote.domain.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Candidate {
    private String id;
    private String name;
}
