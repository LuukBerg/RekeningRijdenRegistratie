package rekeningrijden.fr.rekeningrijdersregistratie.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rekeningrijden.fr.rekeningrijdersregistratie.models.StepDTO;
import rekeningrijden.fr.rekeningrijdersregistratie.service.MovementService;
import rekeningrijden.fr.rekeningrijdersregistratie.service.StepsService;

import javax.websocket.server.PathParam;
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
    public String getLatestStepByTracker(@PathParam("tracker") String tracker){

        return "test: " + tracker;
        //return StepDTO.transform(stepsService.getLatestStepByTracker(tracker));
    }
}
