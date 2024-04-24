package chat.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/chat/sendMessage")
    @SendTo("/topic/chat")
    public String sendMessage(@Payload String message) {
        return message;
    }
}
