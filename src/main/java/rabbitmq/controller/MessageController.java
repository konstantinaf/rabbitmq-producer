package rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rabbitmq.model.ApiResponse;
import rabbitmq.model.Message;
import rabbitmq.model.MessageRS;
import rabbitmq.sender.MessageSender;
import rabbitmq.utils.MessageEventUtilsService;
import rabbitmq.validator.RequestValidator;

/**
 * Created by fotarik on 26/09/2017.
 */
@RestController
public class MessageController{

   @Autowired
   MessageSender messageSender;

   @Autowired
   RequestValidator requestValidator;

   @Autowired
    MessageEventUtilsService messageEventUtilsService;

    @RequestMapping(method= RequestMethod.GET, value={"/phone/{phone_number}"})
    public ApiResponse sendMessage(@PathVariable(value="phone_number") String phoneNumber)
    {
        ApiResponse response = new ApiResponse();
        requestValidator.validateMessage(phoneNumber, response);
        if (response.getError() != null) return response;
        Message event = messageEventUtilsService.generateMessageEvent(phoneNumber);
        messageSender.sendMessage(event);
        return MessageRS.builder().id(event.getId()).phoneNumber(phoneNumber).build();
    }

}
