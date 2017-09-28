package rabbitmq.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by fotarik on 27/09/2017.
 */
@Getter
@AllArgsConstructor
public enum MessageServiceError {

    EMPTY_MESSAGE(32, ErrorCategory.VALIDATION, "Empty MessageRQ"),
    EMPTY_PHONE_NUMBER(33, ErrorCategory.VALIDATION, "Empty Phone Number"),
    WRONG_PHONE_NUMBER_FORMAT(34,ErrorCategory.VALIDATION,"Wrong number format! The phone number should be in E164 format e.g +44161092019");

    private final int code;
    private final ErrorCategory errorCategory;
    private final String message;
}
