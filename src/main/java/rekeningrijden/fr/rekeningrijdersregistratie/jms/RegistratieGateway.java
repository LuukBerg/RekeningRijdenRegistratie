package rekeningrijden.fr.rekeningrijdersregistratie.jms;

import com.rabbitmq.client.DeliverCallback;
import org.springframework.beans.factory.annotation.Autowired;
import rekeningrijden.fr.rekeningrijdersregistratie.jms.gateway.MessageReceiverGateway;
import rekeningrijden.fr.rekeningrijdersregistratie.models.Step;
import rekeningrijden.fr.rekeningrijdersregistratie.service.MovementService;

public class RegistratieGateway {

    @Autowired
    MovementService movementService;
    private MessageReceiverGateway stepReceiver;
    private MessageReceiverGateway stopReceiver;

    public RegistratieGateway(){
        stepReceiver = new MessageReceiverGateway("StepChannel");
        stopReceiver = new MessageReceiverGateway("StopChannel");
        initReceiver();
    }

    private void initReceiver(){
        initStepReceiver();
        initStopReceiver();
    }
    private void initStepReceiver(){
        DeliverCallback deliverCallback = (consumerTag, delivery) ->{
            Step step = Serializer.deserialize(new String(delivery.getBody(), "UTF-8"), Step.class);
            movementService.addStep(step);
        };
        stepReceiver.setListener(deliverCallback);
    }
    private void initStopReceiver(){
        DeliverCallback deliverCallback = (consumerTag, delivery) ->{
            String trackerId = new String(delivery.getBody(),"UTF-8");
            movementService.endMovement(trackerId);
        };
        stopReceiver.setListener(deliverCallback);
    }
}
