package io.github.margato.vs.receivevote.configuration.usecases;

import io.github.margato.vs.receivevote.domain.gateways.SendMessageGateway;
import io.github.margato.vs.receivevote.domain.usecases.AsyncVoteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {
    @Bean
    public AsyncVoteUseCase asyncVoteUseCase(SendMessageGateway sendVoteGateway) {
        return new AsyncVoteUseCase(sendVoteGateway);
    }
}
