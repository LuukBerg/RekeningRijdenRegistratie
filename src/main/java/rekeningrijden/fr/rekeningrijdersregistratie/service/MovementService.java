package rekeningrijden.fr.rekeningrijdersregistratie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import rekeningrijden.fr.rekeningrijdersregistratie.repository.IMovementRepository;
import rekeningrijden.fr.rekeningrijdersregistratie.jms.RegistratieGateway;
import rekeningrijden.fr.rekeningrijdersregistratie.models.Movement;
import rekeningrijden.fr.rekeningrijdersregistratie.models.Step;
import rekeningrijden.fr.rekeningrijdersregistratie.repository.IStepRepository;

@Service
@Configurable
public class MovementService {

    @Autowired
    private IMovementRepository movementRepository;
    @Autowired
    private RegistratieGateway gateway;

    @Autowired
    private IStepRepository stepRepository;

    public void addStep(Step step){
        Movement movement = movementRepository.getByCartrackeraAndActive(step.getTrackerId());
        if(movement == null){
            movement = new Movement(step.getTrackerId());
            movement.setActive(true);
            movement = movementRepository.save(movement);
        }
        movement.getSteps().add(step);
        stepRepository.save(step);
        System.out.println(step);
        movementRepository.save(movement);

    }
    public void endMovement(String trackerid){
        Movement movement = movementRepository.getByCartrackeraAndActive(trackerid);
        if(movement != null){
            movement.setActive(false);
            movementRepository.save(movement);
        }

    }


}
