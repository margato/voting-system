package io.github.margato.vs.voting.boundaries.persistence.repository;

import io.github.margato.vs.voting.boundaries.persistence.entities.VotingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VotingRepository extends JpaRepository<VotingEntity, UUID> {
}
