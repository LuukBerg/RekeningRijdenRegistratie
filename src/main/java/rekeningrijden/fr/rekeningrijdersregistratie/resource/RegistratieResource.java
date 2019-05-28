package rekeningrijden.fr.rekeningrijdersregistratie.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rekeningrijden.fr.rekeningrijdersregistratie.models.StepDTO;
import rekeningrijden.fr.rekeningrijdersregistratie.service.MovementService;
import rekeningrijden.fr.rekeningrijdersregistratie.service.StepsService;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class RegistratieResource {

    @Autowired
    MovementService movementService;

    @Autowired
    StepsService stepsService;

    @GetMapping(path = "/movements")
    public List<StepDTO> getMovements(
        @RequestParam("start") long start,
        @RequestParam("end") long end,
        @RequestParam("page") int pagenumber)
    {
        return StepDTO.transform(stepsService.getSteps(start, end, pagenumber));
    }
}
