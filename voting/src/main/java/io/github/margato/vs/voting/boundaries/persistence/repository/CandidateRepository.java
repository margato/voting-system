package io.github.margato.vs.voting.boundaries.persistence.repository;

import io.github.margato.vs.voting.boundaries.persistence.entities.CandidateEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CandidateRepository extends CrudRepository<CandidateEntity, UUID> {
}
