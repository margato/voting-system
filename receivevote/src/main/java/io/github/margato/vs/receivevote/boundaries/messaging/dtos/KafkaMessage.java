package io.github.margato.vs.receivevote.boundaries.messaging.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class KafkaMessage {
    private String id;

    private String source;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    private Object payload;
}
