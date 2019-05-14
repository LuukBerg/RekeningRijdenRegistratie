package rekeningrijden.fr.rekeningrijdersregistratie;

import com.sun.glass.ui.Application;
import lombok.var;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;
import rekeningrijden.fr.rekeningrijdersregistratie.Repository.IMovementRepository;
import rekeningrijden.fr.rekeningrijdersregistratie.models.Movement;
import rekeningrijden.fr.rekeningrijdersregistratie.models.Step;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovementTest {


    @Autowired
    IMovementRepository movementRepository;
    @Test
    public void MovementTest(){
        //;13.397634,52.529407;13.428555,52.523219?
        Step step1 = new Step(13.388860,52.517037, createDateTimeAgo(180));
        Step step2 = new Step(13.428555,52.523219, createDateTimeAgo(120));
        Step step3 = new Step(13.468555,52.533219, createDateTimeAgo(60));
        Movement movement = new Movement("trackertest");
        movement.getSteps().add(step1);
        movementRepository.save(movement);
        Assert.assertNotNull(movement.getId());
        long id = movement.getId();
        movement = movementRepository.findById(id).get();
        Assert.assertEquals(1, movement.getSteps().size());
        movement.getSteps().add(step2);
        movement.getSteps().add(step3);
        movementRepository.save(movement);
        movement = movementRepository.findById(id).get();
        Assert.assertEquals(3, movement.getSteps().size());


    }
    public Date createDateTimeAgo(int Seconds){
        var seconds = Seconds;
        var dateNow = new Date();
        var returndate = new Date(dateNow.getTime() - seconds*1000);
        return returndate;
    }
}
