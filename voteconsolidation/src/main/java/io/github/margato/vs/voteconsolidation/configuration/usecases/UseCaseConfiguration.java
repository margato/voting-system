package io.github.margato.vs.voteconsolidation.configuration.usecases;

import io.github.margato.vs.voteconsolidation.domain.gateways.UpdateVoteCountGateway;
import io.github.margato.vs.voteconsolidation.domain.usecases.ConsolidateVoteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {
    @Bean
    public ConsolidateVoteUseCase validateVoteUseCase(UpdateVoteCountGateway updateVoteCountGateway) {
        return new ConsolidateVoteUseCase(updateVoteCountGateway);
    }
}
