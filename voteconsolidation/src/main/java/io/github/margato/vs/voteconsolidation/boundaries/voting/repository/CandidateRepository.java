package io.github.margato.vs.voteconsolidation.boundaries.voting.repository;

import io.github.margato.vs.voteconsolidation.boundaries.voting.entities.CandidateEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.UUID;

public interface CandidateRepository extends CrudRepository<CandidateEntity, UUID> {

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE candidates SET votes = votes + :vote_received WHERE id = :candidate_id")
    int updateCount(@Param("candidate_id") UUID candidateId, @Param("vote_received") int votesReceived);

}
