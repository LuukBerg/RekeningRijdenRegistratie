package rekeningrijden.fr.rekeningrijdersregistratie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rekeningrijden.fr.rekeningrijdersregistratie.service.MovementService;

@Configuration
public class MyConfig {
    @Bean
    public MovementService movementService(){
        return new MovementService();
    }
}
