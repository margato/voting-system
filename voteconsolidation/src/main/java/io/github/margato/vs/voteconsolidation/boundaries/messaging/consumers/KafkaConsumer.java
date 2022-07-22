package io.github.margato.vs.voteconsolidation.boundaries.messaging.consumers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.margato.vs.voteconsolidation.boundaries.messaging.dtos.KafkaMessage;
import io.github.margato.vs.voteconsolidation.boundaries.messaging.dtos.VotingPayload;
import io.github.margato.vs.voteconsolidation.domain.entities.Vote;
import io.github.margato.vs.voteconsolidation.domain.usecases.ConsolidateVoteUseCase;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Log4j2
@RequiredArgsConstructor
public class KafkaConsumer {
    private final ConsolidateVoteUseCase validateVoteUseCase;
    private final ObjectMapper mapper;

    @KafkaListener(topics = "${kafka.topic.process-vote}")
    public void handle(ConsumerRecords<String, KafkaMessage> records, Acknowledgment ack) {
        try {
            List<KafkaMessage> kafkaMessages = new ArrayList<>();
            for (ConsumerRecord<String, KafkaMessage> record : records) {
                kafkaMessages.add(record.value());
            }

            log.info("Received {} messages. Partitions: {}", kafkaMessages.size(), records.partitions().toString());

            List<Vote> votes = kafkaMessages.stream()
                    .map(KafkaMessage::getPayload)
                    .map(JsonNode::toString)
                    .map(this::getVotingPayload)
                    .map(payload -> Vote.builder()
                            .votingId(payload.getVotingId())
                            .candidateId(payload.getCandidateId())
                            .build())
                    .collect(Collectors.toList());

            validateVoteUseCase.consolidate(votes);
            ack.acknowledge();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    private VotingPayload getVotingPayload(String json) {
        return mapper.readValue(json, VotingPayload.class);
    }

}
