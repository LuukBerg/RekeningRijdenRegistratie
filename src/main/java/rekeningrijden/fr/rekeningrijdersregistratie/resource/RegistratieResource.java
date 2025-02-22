package rekeningrijden.fr.rekeningrijdersregistratie.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rekeningrijden.fr.rekeningrijdersregistratie.models.StepDTO;
import rekeningrijden.fr.rekeningrijdersregistratie.service.MovementService;
import rekeningrijden.fr.rekeningrijdersregistratie.service.StepsService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class RegistratieResource
{
    @Autowired
    MovementService movementService;

    @Autowired
    StepsService stepsService;

    @GetMapping(path = "/movements")
    public List<StepDTO> getMovements(
        @RequestParam("start") long start,
        @RequestParam("end") long end,
        @RequestParam("page") int pagenumber,
        @RequestParam(name = "pagesize", defaultValue = "1000") int pageSize)
    {
        return StepDTO.transform(stepsService.getSteps(new Date(start), new Date(end), pagenumber, pageSize));
    }

    @GetMapping(path = "/tracker/{tracker}/movements")
    public List<StepDTO> getMovements(
        @PathVariable("tracker") String tracker,
        @RequestParam("start") long start,
        @RequestParam("end") long end,
        @RequestParam("page") int pagenumber,
        @RequestParam(name = "pagesize", defaultValue = "1000") int pageSize)
    {
        return StepDTO.transform(stepsService.getTrackerSteps(tracker, new Date(start), new Date(end), pagenumber, pageSize));
    }

    @GetMapping(path = "/tracker/{tracker}/movement")
    public List<StepDTO> getLatestStepByTracker(@PathVariable("tracker") String tracker){
        return StepDTO.transform(stepsService.getLatestStepByTracker(tracker));
    }
}
