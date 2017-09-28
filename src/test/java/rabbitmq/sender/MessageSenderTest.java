package rabbitmq.sender;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import rabbitmq.helpers.MessageProducedCounterHelper;
import rabbitmq.model.Message;
import rabbitmq.utils.MessageEventUtilsService;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Created by fotarik on 27/09/2017.
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MessageSenderTest {

    @Autowired
    MessageSender messageSender;

    @Autowired
    MessageEventUtilsService messageEventUtilsService;

    private CountDownLatch lock = new CountDownLatch(1);

    private final String ENGLISH_PHONE_NUMBER ="+441111119020";
    @Test
    public void sendMessage() throws Exception {
        //send a message to the correct queue
        Message event = messageEventUtilsService.generateMessageEvent(ENGLISH_PHONE_NUMBER);
        messageSender.sendMessage(event);
        lock.await(2000, TimeUnit.MILLISECONDS);
        assertEquals(MessageProducedCounterHelper.getInstance().getCounter().longValue(),1L);
    }


}
