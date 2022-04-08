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
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "voting_id")
    private VotingEntity voting;
}