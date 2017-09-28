package rabbitmq.validator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import rabbitmq.error.MessageServiceError;
import rabbitmq.model.ApiResponse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by fotarik on 27/09/2017.
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RequestValidatorTest {

    @Autowired
    RequestValidator requestValidator;

    @Test
    public void testValidatorWithNullRQ() {
        String phoneNumber = null;
        ApiResponse apiResponse = new ApiResponse();
        requestValidator.validateMessage(phoneNumber, apiResponse);
        assertEquals(apiResponse.getError().getId().intValue(), MessageServiceError.EMPTY_PHONE_NUMBER.getCode());

    }

    @Test
    public void testValidatorWithEmptyPhoneNumber() {
        String phoneNumber = "";
        ApiResponse apiResponse = new ApiResponse();
        requestValidator.validateMessage(phoneNumber, apiResponse);
        assertEquals(apiResponse.getError().getId().intValue(), MessageServiceError.EMPTY_PHONE_NUMBER.getCode());

    }

    @Test
    public void testValidatorWithWrongFormatNumber() {
        String phoneNumber = "76732676327";
        ApiResponse apiResponse = new ApiResponse();
        requestValidator.validateMessage(phoneNumber, apiResponse);
        assertEquals(apiResponse.getError().getId().intValue(), MessageServiceError.WRONG_PHONE_NUMBER_FORMAT.getCode());

    }

    @Test
    public void testValidatorSuccess() {
        String phoneNumber = "+306988190541";
        ApiResponse apiResponse = new ApiResponse();
        requestValidator.validateMessage(phoneNumber, apiResponse);
        assertNull(apiResponse.getError());

    }
}

