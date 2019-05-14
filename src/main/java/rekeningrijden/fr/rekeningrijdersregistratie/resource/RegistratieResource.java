package rekeningrijden.fr.rekeningrijdersregistratie.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rekeningrijden.fr.rekeningrijdersregistratie.Repository.IMovementRepository;
import rekeningrijden.fr.rekeningrijdersregistratie.models.Movement;
import rekeningrijden.fr.rekeningrijdersregistratie.models.Step;
import rekeningrijden.fr.rekeningrijdersregistratie.service.MovementService;

@RestController
@RequestMapping(path = "/api")
public class RegistratieResource {

    @Autowired
    MovementService movementService;

    @PostMapping
    public void createStep(@RequestBody Step step){
        movementService.addStep(step);

    }
}
