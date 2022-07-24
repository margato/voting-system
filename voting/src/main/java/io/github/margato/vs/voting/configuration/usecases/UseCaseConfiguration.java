package io.github.margato.vs.voting.configuration.usecases;

import io.github.margato.vs.voting.domain.gateways.*;
import io.github.margato.vs.voting.domain.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public AddCandidateUseCase addCandidateUseCase(GetVotingByIdGateway getVotingByIdGateway, AddCandidateGateway addCandidateGateway) {
        return new AddCandidateUseCase(addCandidateGateway, getVotingByIdGateway);
    }

    @Bean
    public CreateVotingUseCase createVotingUseCase(CreateVotingGateway createVotingGateway) {
        return new CreateVotingUseCase(createVotingGateway);
    }

    @Bean
    public GetAllVotingsUseCase getAllVotingsUseCase(GetAllVotingsGateway getAllVotingsGateway) {
        return new GetAllVotingsUseCase(getAllVotingsGateway);
    }

    @Bean
    public GetVotingByIdUseCase getVotingByIdUseCase(GetVotingByIdGateway getVotingByIdGateway) {
        return new GetVotingByIdUseCase(getVotingByIdGateway);
    }

    @Bean
    public RemoveVotingByIdUseCase removeVotingByIdUseCase(RemoveVotingByIdGateway removeVotingByIdGateway) {
        return new RemoveVotingByIdUseCase(removeVotingByIdGateway);
    }

}
