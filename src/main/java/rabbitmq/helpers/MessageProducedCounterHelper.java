package rabbitmq.helpers;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by fotarik on 27/09/2017.
 */
public enum MessageProducedCounterHelper {
    INSTANCE;

    @Getter
    private AtomicLong counter = new AtomicLong(0L);

    public static MessageProducedCounterHelper getInstance() {
        return MessageProducedCounterHelper.INSTANCE;
    }
}