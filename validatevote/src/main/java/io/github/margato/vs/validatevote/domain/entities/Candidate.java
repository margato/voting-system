package io.github.margato.vs.validatevote.domain.entities;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Candidate {
    private String id;
    private String name;
}
