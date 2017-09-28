package rabbitmq.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by fotarik on 28/09/2017.
 */
public class MessageTest {

    @Test
    public void testBuilder() {
        Message message = Message.builder().build();
        assertNotNull(message);
    }

    @Test
    public void testBuilderWithId() {
        Message message = Message.builder().id("123").build();
        assertNotNull(message);
        assertEquals(message.getId(),"123");
    }

    @Test
    public void testBuilderWithPhoneNumber() {
        Message message = Message.builder().phoneNumber("12345").build();
        assertNotNull(message);
        assertEquals(message.getPhoneNumber(),"12345");
    }

    @Test
    public void testBuilderWithIdAndPhoneNumber() {
        Message message = Message.builder().id("123").phoneNumber("12345").build();
        assertNotNull(message);
        assertEquals(message.getId(),"123");
        assertEquals(message.getPhoneNumber(),"12345");
    }
}
