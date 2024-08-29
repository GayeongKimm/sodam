package hackers.ground.sodam.domain.chat.presentation.controller;

import hackers.ground.sodam.domain.chat.service.ChatService;
import hackers.ground.sodam.domain.file.service.AIService;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/chat-gpt")
public class GptController {

    private final ChatService chatService;
    private final ChatgptService chatgptService;
    private final AIService aiService;

    @PostMapping("/image")
    public ResponseEntity<?> generateImage(@RequestBody String prompt) {
        return new ResponseEntity<>(aiService.generatePicture(prompt), HttpStatus.OK);
    }
}

