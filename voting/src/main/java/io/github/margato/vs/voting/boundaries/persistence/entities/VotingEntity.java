package io.github.margato.vs.voting.boundaries.persistence.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Table(name = "votings")
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class VotingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;

    @Column(name = "min_candidates", nullable = false)
    private int minCandidates;

    @Column(name = "max_candidates", nullable = false)
    private int maxCandidates;

    @Setter
    @Column(name = "active")
    private boolean active;

    @OneToMany(mappedBy = "voting")
    private List<CandidateEntity> candidates;
}
