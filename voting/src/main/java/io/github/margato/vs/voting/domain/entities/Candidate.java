package io.github.margato.vs.voting.domain.entities;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Candidate implements Comparable<Candidate> {
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

    @Override
    public int compareTo(Candidate candidate) {
        if (this == candidate) return 0;

        if (candidate.getVotes() > this.getVotes()) return 1;
        else return -1;
    }
}
