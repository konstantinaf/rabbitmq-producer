package rabbitmq.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by fotarik on 27/09/2017.
 */
@Getter
@Setter
public class ApiResponse implements Serializable {

    private ApiError error;
}
