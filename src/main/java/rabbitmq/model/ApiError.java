package rabbitmq.model;

import lombok.Builder;
import lombok.Getter;
import rabbitmq.error.ErrorCategory;

import java.io.Serializable;

/**
 * Created by fotarik on 27/09/2017.
 */
@Getter
@Builder
public class ApiError implements Serializable {

    protected Integer id;
    protected String message;
    protected ErrorCategory category;
}
