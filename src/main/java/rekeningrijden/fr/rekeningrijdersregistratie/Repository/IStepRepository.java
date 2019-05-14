package rekeningrijden.fr.rekeningrijdersregistratie.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rekeningrijden.fr.rekeningrijdersregistratie.models.Step;

public interface IStepRepository extends JpaRepository<Step, Long> {


}
