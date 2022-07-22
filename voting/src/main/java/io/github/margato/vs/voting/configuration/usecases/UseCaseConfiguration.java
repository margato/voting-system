package io.github.margato.vs.voting.configuration.usecases;

import io.github.margato.vs.voting.domain.gateways.AddCandidateGateway;
import io.github.margato.vs.voting.domain.gateways.CreateVotingGateway;
import io.github.margato.vs.voting.domain.gateways.GetAllVotingsGateway;
import io.github.margato.vs.voting.domain.gateways.GetVotingByIdGateway;
import io.github.margato.vs.voting.domain.usecases.AddCandidateUseCase;
import io.github.margato.vs.voting.domain.usecases.CreateVotingUseCase;
import io.github.margato.vs.voting.domain.usecases.GetAllVotingsUseCase;
import io.github.margato.vs.voting.domain.usecases.GetVotingByIdUseCase;
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

}
