package rabbitmq.utils;

import org.springframework.stereotype.Service;
import rabbitmq.model.Message;

import java.util.UUID;

/**
 * Created by fotarik on 27/09/2017.
 */
@Service
public class MessageEventUtilsService {

    public Message generateMessageEvent(String phoneNumber) {
        UUID uuid = UUID.randomUUID();
        return Message.builder().id(uuid.toString()).phoneNumber(phoneNumber).build();

    }
}
