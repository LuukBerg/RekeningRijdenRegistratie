package rekeningrijden.fr.rekeningrijdersregistratie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import rekeningrijden.fr.rekeningrijdersregistratie.models.Step;
import rekeningrijden.fr.rekeningrijdersregistratie.repository.IStepRepository;

import java.util.Date;
import java.util.List;

@Service
public class StepsService {

    @Autowired
    private IStepRepository stepRepository;

    private final static int PAGESIZE = 1000;


    public List<Step> getSteps(long start, long end, int pagenumber) {
        Pageable pageRequest = PageRequest.of(pagenumber,PAGESIZE);
        System.out.println(new Date(start));
        System.out.println(new Date(end));
        System.out.println(pagenumber);
        return stepRepository.getStepsByDate();
                // new Date(start), new Date(end), pageRequest);

    }
}
