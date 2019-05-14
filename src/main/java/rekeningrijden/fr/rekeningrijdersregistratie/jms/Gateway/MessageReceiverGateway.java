package rekeningrijden.fr.rekeningrijdersregistratie.jms.Gateway;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class MessageReceiverGateway {

    private Channel channel;
    private String channelName;

    public MessageReceiverGateway(String channelName){
        this.channelName = channelName;
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.24.180");
        factory.setPort(1011);
        Connection connection = null;
        try {
            connection = factory.newConnection();
            channel = connection.createChannel();
            channel.queueDeclare(channelName,false,false,false,null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    public String setListener(DeliverCallback dc){
        try {
            return channel.basicConsume(channelName,true,dc,consumerTag ->{});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Channel getChannel() {
        return channel;
    }
}
