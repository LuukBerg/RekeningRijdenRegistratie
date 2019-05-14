package rekeningrijden.fr.rekeningrijdersregistratie.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rekeningrijden.fr.rekeningrijdersregistratie.models.Step;
import rekeningrijden.fr.rekeningrijdersregistratie.service.MovementService;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

@RestController
@RequestMapping(path = "/api")
public class RegistratieResource {

    @Autowired
    MovementService movementService;

    @GetMapping(path = "/movements/{year}/{month}")
    public void getMovements( @PathVariable("year") short year ,@PathVariable("month") Month month){
        LocalDate startDate = Year.of(year).atMonth(month).atDay(1);
        LocalDate endDate = Year.of(year).atMonth(month).atEndOfMonth();

    }
}
