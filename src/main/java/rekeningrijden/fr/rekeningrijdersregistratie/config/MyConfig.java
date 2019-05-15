package rekeningrijden.fr.rekeningrijdersregistratie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rekeningrijden.fr.rekeningrijdersregistratie.service.MovementService;
import rekeningrijden.fr.rekeningrijdersregistratie.service.StepsService;

@Configuration
public class MyConfig {
    @Bean
    public MovementService movementService(){
        return new MovementService();
    }
    @Bean
    public StepsService stepsService(){
        return new StepsService();
    }
}
