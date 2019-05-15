package rekeningrijden.fr.rekeningrijdersregistratie.service;

import org.springframework.beans.factory.annotation.Autowired;
import rekeningrijden.fr.rekeningrijdersregistratie.repository.IMovementRepository;
import rekeningrijden.fr.rekeningrijdersregistratie.jms.RegistratieGateway;
import rekeningrijden.fr.rekeningrijdersregistratie.models.Movement;
import rekeningrijden.fr.rekeningrijdersregistratie.models.Step;


public class MovementService {
    @Autowired
    IMovementRepository movementRepository;

    private RegistratieGateway gateway = new RegistratieGateway();

    public void addStep(Step step){
        Movement movement = movementRepository.getByCartrackeraAndActive(step.getTrackerId());
        if(movement == null){
            movement = new Movement(step.getTrackerId());
            movementRepository.save(movement);
        }
        movement.getSteps().add(step);
    }
    public void endMovement(String trackerid){
        Movement movement = movementRepository.getByCartrackeraAndActive(trackerid);
        if(movement != null){
            movement.setActive(false);
            movementRepository.save(movement);
        }

    }


}
