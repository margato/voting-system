package io.github.margato.vs.voting.boundaries.persistence.repository;

import io.github.margato.vs.voting.boundaries.persistence.entities.VotingEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface VotingRepository extends CrudRepository<VotingEntity, UUID> {
}
