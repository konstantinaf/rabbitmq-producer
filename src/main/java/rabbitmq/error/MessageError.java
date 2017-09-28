package rabbitmq.error;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

/**
 * Created by fotarik on 27/09/2017.
 */
@Getter
@Builder
public class MessageError implements Serializable{

    private int errorCode;
    private String errorMessage;
}
