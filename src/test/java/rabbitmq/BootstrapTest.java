package rabbitmq;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created by fotarik on 28/09/2017.
 */
@SpringBootTest
public class BootstrapTest {

    @Test
    public void testSpringBootApplicationRun() throws InterruptedException {
        Bootstrap.main(new String[]{
                "--spring.main.web-environment=false",
                "--spring.autoconfigure.exclude=blahblahblah",
        });
    }

}
