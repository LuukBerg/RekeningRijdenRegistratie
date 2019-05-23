package rekeningrijden.fr.rekeningrijdersregistratie.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rekeningrijden.fr.rekeningrijdersregistratie.jms.RegistratieGateway;
import rekeningrijden.fr.rekeningrijdersregistratie.models.Step;
import rekeningrijden.fr.rekeningrijdersregistratie.models.StepDTO;
import rekeningrijden.fr.rekeningrijdersregistratie.service.MovementService;
import rekeningrijden.fr.rekeningrijdersregistratie.service.StepsService;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class RegistratieResource {

    @Autowired
    MovementService movementService;

    @Autowired
    StepsService stepsService;


    @GetMapping(path = "/movements/{start}/{end}/{pagenumber}")
    public List<StepDTO> getMovements(@PathVariable("start") long start , @PathVariable("end") long end, @PathVariable("pagenumber") int pagenumber){
        return StepDTO.transform(stepsService.getSteps(start, end, pagenumber));
    }
}
