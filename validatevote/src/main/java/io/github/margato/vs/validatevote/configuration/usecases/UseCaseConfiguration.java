package io.github.margato.vs.validatevote.configuration.usecases;

import io.github.margato.vs.validatevote.domain.gateways.GetVotingByIdGateway;
import io.github.margato.vs.validatevote.domain.gateways.SendMessageGateway;
import io.github.margato.vs.validatevote.domain.usecases.ValidateVoteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {
    @Bean
    public ValidateVoteUseCase validateVoteUseCase(SendMessageGateway sendVoteGateway,
                                                   GetVotingByIdGateway getVotingByIdGateway) {
        return new ValidateVoteUseCase(sendVoteGateway, getVotingByIdGateway);
    }
}
