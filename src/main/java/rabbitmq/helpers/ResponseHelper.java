package rabbitmq.helpers;

import org.springframework.stereotype.Service;
import rabbitmq.error.MessageServiceError;
import rabbitmq.model.ApiError;

/**
 * Created by fotarik on 27/09/2017.
 */
@Service
public class ResponseHelper {

    public ApiError createError(MessageServiceError messageServiceError) {
        return ApiError.builder().id(messageServiceError.getCode()).message(messageServiceError.getMessage()).category(messageServiceError.getErrorCategory()).build();
    }
}
