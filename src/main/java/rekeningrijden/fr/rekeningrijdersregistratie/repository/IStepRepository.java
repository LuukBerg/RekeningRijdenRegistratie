package rekeningrijden.fr.rekeningrijdersregistratie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rekeningrijden.fr.rekeningrijdersregistratie.models.Step;

public interface IStepRepository extends JpaRepository<Step, Long> {


}
