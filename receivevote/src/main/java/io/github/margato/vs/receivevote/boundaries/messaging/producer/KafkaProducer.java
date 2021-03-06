package io.github.margato.vs.receivevote.boundaries.messaging.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.margato.vs.receivevote.boundaries.messaging.dtos.KafkaMessage;
import io.github.margato.vs.receivevote.boundaries.messaging.exceptions.MessageNotDeliveredException;
import io.github.margato.vs.receivevote.domain.gateways.SendMessageGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class KafkaProducer implements SendMessageGateway {
    private final KafkaTemplate<String, KafkaMessage> kafkaTemplate;
    private final ObjectMapper mapper;

    @Value("${kafka.topic.new-vote}")
    private String topic;

    @Value("${spring.application.name}")
    private String applicationName;

    private String source;

    @PostConstruct
    public void setSource() {
        source = applicationName + "-" + getHostName();
    }

    @Override
    public void send(Object payload) {
        try {
            String key = UUID.randomUUID().toString();

            KafkaMessage kafkaMessage = KafkaMessage.builder()
                    .id(key)
                    .createdAt(LocalDateTime.now())
                    .source(source)
                    .payload(mapper.readTree(mapper.writeValueAsString(payload)))
                    .build();

            SendResult<String, KafkaMessage> sendResult = kafkaTemplate.send(topic, key, kafkaMessage).get();

            log.info(
                    "Message sent to kafka topic '{}' - Record: {}",
                    topic,
                    sendResult.getProducerRecord().toString()
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw new MessageNotDeliveredException();
        }
    }

    private String getHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            return "UnknownHost";
        }
    }
}
