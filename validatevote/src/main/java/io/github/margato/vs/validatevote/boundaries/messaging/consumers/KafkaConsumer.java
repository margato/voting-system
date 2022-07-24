package io.github.margato.vs.validatevote.boundaries.messaging.consumers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.margato.vs.validatevote.boundaries.messaging.dtos.KafkaMessage;
import io.github.margato.vs.validatevote.boundaries.messaging.dtos.VotingPayload;
import io.github.margato.vs.validatevote.domain.exceptions.InvalidVotingException;
import io.github.margato.vs.validatevote.domain.usecases.ValidateVoteUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
@Log4j2
@RequiredArgsConstructor
public class KafkaConsumer {
    private final ValidateVoteUseCase validateVoteUseCase;
    private final ObjectMapper mapper;

    @KafkaListener(topics = "${kafka.topic.new-vote}")
    public void handle(ConsumerRecord<String, KafkaMessage> consumerRecord, Acknowledgment ack) {
        try {
            KafkaMessage kafkaMessage = consumerRecord.value();

            log.info(
                    "Key: {}, Source: {}, Created At: {}, Partition: {}, Offset: {}",
                    kafkaMessage.getId(),
                    kafkaMessage.getSource(),
                    kafkaMessage.getCreatedAt(),
                    consumerRecord.partition(),
                    consumerRecord.offset()
            );

            VotingPayload votingPayload = mapper.readValue(kafkaMessage.getPayload().toString(), VotingPayload.class);
            validateVoteUseCase.validate(votingPayload.getVotingId(), votingPayload.getCandidateId());
            ack.acknowledge();
        } catch (InvalidVotingException e) {
            ack.acknowledge();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
