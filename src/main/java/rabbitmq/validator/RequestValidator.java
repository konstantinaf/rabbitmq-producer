package rabbitmq.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rabbitmq.error.MessageServiceError;
import rabbitmq.helpers.ResponseHelper;
import rabbitmq.model.ApiResponse;

/**
 * Created by fotarik on 26/09/2017.
 */
@Service
public class RequestValidator {

    @Autowired
    ResponseHelper responseHelper;

    public void validateMessage(String phoneNumber, ApiResponse response) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            response.setError(responseHelper.createError(MessageServiceError.EMPTY_PHONE_NUMBER));
        }
        else if (!phoneNumber.matches("^\\+[1-9]\\d{1,14}$")) {
            response.setError(responseHelper.createError(MessageServiceError.WRONG_PHONE_NUMBER_FORMAT));
        }

    }

}
