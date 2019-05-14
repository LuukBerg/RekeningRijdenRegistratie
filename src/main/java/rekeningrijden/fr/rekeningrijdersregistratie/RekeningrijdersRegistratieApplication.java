package rekeningrijden.fr.rekeningrijdersregistratie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "rekeningrijden.fr.rekeningrijdersregistratie.repository")
@SpringBootApplication
public class RekeningrijdersRegistratieApplication {
    public static void main(String[] args) {
        SpringApplication.run(RekeningrijdersRegistratieApplication.class, args);
    }

}
