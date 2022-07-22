package io.github.margato.vs.voting.domain.entities;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Candidate {
    private String id;
    private String name;
    private String imageUrl;
    private int votes;

    @Override
    public String toString() {
        return "Candidate{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
