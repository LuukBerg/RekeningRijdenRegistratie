package rekeningrijden.fr.rekeningrijdersregistratie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import rekeningrijden.fr.rekeningrijdersregistratie.models.Step;
import rekeningrijden.fr.rekeningrijdersregistratie.repository.IStepRepository;

import java.util.Date;
import java.util.List;

public class StepsService {

    @Autowired
    IStepRepository stepRepository;

    private final static int PAGESIZE = 1000;


    public List<Step> getSteps(long start, long end, int pagenumber) {
        Pageable pageRequest = PageRequest.of(pagenumber,PAGESIZE);
        return stepRepository.getStepsByDate(new Date(start), new Date(end), pageRequest);

    }
}
