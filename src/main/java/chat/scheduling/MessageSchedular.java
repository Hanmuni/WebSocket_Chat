package chat.scheduling;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component

@RequiredArgsConstructor
public class MessageSchedular {

    private final SimpMessagingTemplate template;

    @Scheduled(fixedRate = 5000)
    public void scheduledMessage() {
        this.template.convertAndSend("/topic/chat", "Message from server!");
        System.out.println("Message sent!");
    }

}
