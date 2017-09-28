package rabbitmq.error;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by fotarik on 28/09/2017.
 */
@SpringBootTest
public class MessageErrorTest {

    @Test
    public void testBuilder() {
        MessageError messageError = MessageError.builder().build();
        assertNotNull(messageError);
    }

    @Test
    public void testBuilderWithErrorCode() {
        MessageError messageError = MessageError.builder().errorCode(1).build();
        assertNotNull(messageError);
        assertEquals(messageError.getErrorCode(),1);
    }

    @Test
    public void testBuilderWithErrorMessage() {
        MessageError messageError = MessageError.builder().errorMessage("ErrorMessage").build();
        assertNotNull(messageError);
        assertEquals(messageError.getErrorMessage(),"ErrorMessage");
    }

    @Test
    public void testBuilderWithCodeAndErrorMessage() {
        MessageError messageError = MessageError.builder().errorCode(1).errorMessage("ErrorMessage").build();
        assertNotNull(messageError);
        assertEquals(messageError.getErrorCode(),1);
        assertEquals(messageError.getErrorMessage(),"ErrorMessage");
    }
}
