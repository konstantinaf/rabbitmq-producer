package rabbitmq.helper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import rabbitmq.error.MessageServiceError;
import rabbitmq.helpers.ResponseHelper;
import rabbitmq.model.ApiError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by fotarik on 27/09/2017.
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ResponseHelperTest {

    @Autowired
    ResponseHelper responseHelper;

    @Test
    public void testCreateError() {
        ApiError apiError = responseHelper.createError(MessageServiceError.WRONG_PHONE_NUMBER_FORMAT);
        assertNotNull(apiError);
        assertEquals(apiError.getId().intValue(), MessageServiceError.WRONG_PHONE_NUMBER_FORMAT.getCode());

    }
}
