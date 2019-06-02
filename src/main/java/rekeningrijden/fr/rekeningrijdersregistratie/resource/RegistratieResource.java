package rekeningrijden.fr.rekeningrijdersregistratie.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import rekeningrijden.fr.rekeningrijdersregistratie.models.Step;
import rekeningrijden.fr.rekeningrijdersregistratie.models.StepDTO;
import rekeningrijden.fr.rekeningrijdersregistratie.service.MovementService;
import rekeningrijden.fr.rekeningrijdersregistratie.service.StepsService;

import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

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
        @RequestParam("page") int pagenumber)
    {
        return StepDTO.transform(stepsService.getSteps(new Date(start), new Date(end), pagenumber));
    }

    @GetMapping(path = "/tracker/{tracker}/movements")
    public List<StepDTO> getMovements(
        @PathParam("tracker") String tracker,
        @RequestParam("start") long start,
        @RequestParam("end") long end,
        @RequestParam("page") int pagenumber)
    {
        return StepDTO.transform(stepsService.getTrackerSteps(tracker, new Date(start), new Date(end), pagenumber));
    }

    @GetMapping(path = "/tracker/{tracker}/movement")
    public List<StepDTO> getLatestStepByTracker(@PathParam("tracker") String tracker){
        return StepDTO.transform(stepsService.getLatestStepByTracker(tracker, PageRequest.of(0, 1)));
    }
}
