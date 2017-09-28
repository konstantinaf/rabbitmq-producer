package rabbitmq.error;

import java.io.Serializable;

/**
 * Created by fotarik on 27/09/2017.
 */
public enum ErrorCategory implements Serializable {
    VALIDATION("Validation"),
    BUSINESS("Business"),
    SYSTEM("System"),
    UNKNOWN("Unknown");

    private final String value;

    ErrorCategory(String v) {
        value = v;
    }

}
