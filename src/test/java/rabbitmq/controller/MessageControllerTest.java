package rabbitmq.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import rabbitmq.helpers.ResponseHelper;
import rabbitmq.model.Message;
import rabbitmq.sender.MessageSender;
import rabbitmq.utils.MessageEventUtilsService;
import rabbitmq.validator.RequestValidator;

import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by fotarik on 27/09/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MessageControllerTest {

    private final String ENGLISH_PHONE_NUMBER = "+441111119020";
    @Mock
    MessageSender messageSender;

    @Mock
    RequestValidator requestValidator;

    @Mock
    MessageEventUtilsService messageEventUtilsService;

    @InjectMocks
    MessageController messageController;

    @Spy
    ResponseHelper responseHelper = new ResponseHelper();

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        this.mockMvc = MockMvcBuilders.standaloneSetup(messageController).build();

    }

    @Test
    public void testSendPhoneMessage() throws Exception {
        Message event = Message.builder().id("123").phoneNumber(ENGLISH_PHONE_NUMBER).build();
        when(messageEventUtilsService.generateMessageEvent(ENGLISH_PHONE_NUMBER)).thenReturn(event);
        this.mockMvc.perform(get("/phone/" + ENGLISH_PHONE_NUMBER)
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));

        verify(messageSender, times(1)).sendMessage(event);
        verifyNoMoreInteractions(messageSender);

    }

}
