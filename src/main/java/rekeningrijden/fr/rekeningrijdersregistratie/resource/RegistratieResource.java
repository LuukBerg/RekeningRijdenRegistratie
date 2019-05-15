package rekeningrijden.fr.rekeningrijdersregistratie.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rekeningrijden.fr.rekeningrijdersregistratie.models.Step;
import rekeningrijden.fr.rekeningrijdersregistratie.service.MovementService;
import rekeningrijden.fr.rekeningrijdersregistratie.service.StepsService;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

@RestController
@RequestMapping(path = "/api")
public class RegistratieResource {

    @Autowired
    MovementService movementService;

    @Autowired
    StepsService stepsService;

    @GetMapping(path = "/movements/{start}/{end}/{pagenumber}")
    public void getMovements( @PathVariable("start") long start ,@PathVariable("end") long end, @PathVariable("pagenumber") int pagenumber){
        stepsService.getSteps(start, end, pagenumber);
    }
}
