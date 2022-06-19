package io.github.margato.vs.validatevote.boundaries.messaging.consumers;

import io.github.margato.vs.validatevote.boundaries.messaging.dtos.KafkaMessage;
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

    @KafkaListener(topics = "${kafka.topic.new-vote}")
    public void handle(ConsumerRecord<String, KafkaMessage> consumerRecord, Acknowledgment ack) {
        KafkaMessage kafkaMessage = consumerRecord.value();

        log.info(
                "Key: {}, Source: {}, Created At: {}, Partition: {}, Offset: {}",
                kafkaMessage.getId(),
                kafkaMessage.getSource(),
                kafkaMessage.getCreatedAt(),
                consumerRecord.partition(),
                consumerRecord.offset()
        );

        ack.acknowledge();
    }

}
