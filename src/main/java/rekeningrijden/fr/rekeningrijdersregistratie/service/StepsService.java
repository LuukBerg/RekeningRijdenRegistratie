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
public class StepsService
{
    @Autowired
    private IStepRepository stepRepository;

    private final static int PAGESIZE = 1000;

    public List<Step> getSteps(Date start, Date end, int pagenumber)
    {
        Pageable pageRequest = PageRequest.of(pagenumber,PAGESIZE);
        return stepRepository.getStepsByDate(start, end, pageRequest);
    }

    public List<Step> getTrackerSteps(String tracker, Date start, Date end, int pagenumber)
    {
        Pageable pageRequest = PageRequest.of(pagenumber,PAGESIZE);
        return stepRepository.getStepsByTracker(tracker, start, end, pageRequest);
    }

    public Step getLatestStepByTracker(String tracker){
        return stepRepository.getLatestStepByTracker(tracker);
    }
}
