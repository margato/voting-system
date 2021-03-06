package io.github.margato.vs.receivevote.boundaries.messaging.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class KafkaMessage {
    private String id;

    private String source;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    private JsonNode payload;
}
