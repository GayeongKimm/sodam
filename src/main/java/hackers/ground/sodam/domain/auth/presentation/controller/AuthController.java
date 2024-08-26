package hackers.ground.sodam.domain.auth.presentation.controller;

import hackers.ground.sodam.domain.auth.presentation.dto.req.UserSignUpReq;
import hackers.ground.sodam.domain.user.enums.UserCategory;
import hackers.ground.sodam.global.response.Response;
import hackers.ground.sodam.global.response.ResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hackers.ground.sodam.domain.auth.presentation.dto.req.SignInReq;
import hackers.ground.sodam.domain.auth.presentation.dto.req.SignUpReq;
import hackers.ground.sodam.domain.auth.presentation.dto.res.TokenRes;
import hackers.ground.sodam.domain.auth.service.AuthService;

@Tag(name = "Auth", description = "Auth Api")
@RestController
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @Operation(description = "회원가입")
    @PostMapping("/sign_up")
    public ResponseData<UserCategory> signUp(
            @RequestBody @Valid UserSignUpReq userSignUpReq
            ){
        return authService.signUp(userSignUpReq);
    }

    @Operation(description = "장사")
    @PostMapping("/sign_up/seller")
    public ResponseData<UserCategory> signUpSeller(
            @RequestBody @Valid SignUpReq signUpReq
    ){
        return authService.signUpSeller(signUpReq);
    }

    @Operation(description = "로그인")
    @PostMapping("/sign_in")
    public ResponseData<TokenRes> signIn(
            @RequestBody @Valid SignInReq signInReq
    ){
        return authService.signIn(signInReq);
    }
}
