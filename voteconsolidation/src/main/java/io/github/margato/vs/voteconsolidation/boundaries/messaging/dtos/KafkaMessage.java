package io.github.margato.vs.voteconsolidation.boundaries.messaging.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDateTime;

@Getter
@Builder
@Jacksonized
public class KafkaMessage {
    private String id;

    private String source;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    private JsonNode payload;
}
