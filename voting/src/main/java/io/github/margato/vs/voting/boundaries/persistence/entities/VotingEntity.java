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
    @Column(name = "id")
    private UUID id;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "name")
    private String name;

    @Column(name = "image_url")
    private String imageUrl;

    @Setter
    @Column(name = "active")
    private boolean active;

    @OneToMany(mappedBy = "voting", cascade = CascadeType.REMOVE)
    private List<CandidateEntity> candidates;

    @Column(name="created_at", insertable = false)
    private LocalDateTime createdAt;
}
