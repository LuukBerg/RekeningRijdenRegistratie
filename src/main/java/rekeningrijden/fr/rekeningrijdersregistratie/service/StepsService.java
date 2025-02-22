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

    public List<Step> getSteps(Date start, Date end, int pagenumber, int pagesize)
    {
        Pageable pageRequest = PageRequest.of(pagenumber,pagesize);
        return stepRepository.getStepsByDate(start, end, pageRequest);
    }

    public List<Step> getTrackerSteps(String tracker, Date start, Date end, int pagenumber, int pagesize)
    {
        Pageable pageRequest = PageRequest.of(pagenumber, pagesize);
        return stepRepository.getStepsByTracker(tracker, start, end, pageRequest);
    }

    public List<Step> getLatestStepByTracker(String tracker){
        Pageable pageRequest = PageRequest.of(0,1);
        return stepRepository.getLatestStepByTracker(tracker, pageRequest);
    }
}
