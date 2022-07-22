package io.github.margato.vs.voting.boundaries.persistence.entities;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "candidates")
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CandidateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "votes")
    private int votes;

    @ManyToOne
    @JoinColumn(name = "voting_id")
    private VotingEntity voting;
}