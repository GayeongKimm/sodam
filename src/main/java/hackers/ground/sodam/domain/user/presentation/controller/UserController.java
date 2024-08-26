package hackers.ground.sodam.domain.user.presentation.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "User", description = "User Api")
@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {



}
