package rabbitmq.sender;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import rabbitmq.helpers.MessageProducedCounterHelper;
import rabbitmq.model.Message;

/**
 * Created by fotarik on 26/09/2017.
 */
@Service
@Slf4j
public class MessageSender {

    @Value(value = "${rabbitmq.queue.name}")
    private String queueName;
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public MessageSender(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    public void sendMessage(Message message) {
        MessageProducedCounterHelper.getInstance().getCounter().incrementAndGet();
        log.info("Sending messageRQ...");
        rabbitTemplate.convertAndSend("rabbitmq-example-exchange", queueName, message);
    }
}
