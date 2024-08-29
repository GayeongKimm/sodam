package hackers.ground.sodam.domain.chat.service;

import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatgptService chatgptService;

    public String getImageResponse(String prompt) {
        return chatgptService.imageGenerate(prompt);
    }
}