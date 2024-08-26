package sodam.domain.auth.presentation.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sodam.domain.auth.presentation.dto.req.SignInReq;
import sodam.domain.auth.presentation.dto.req.SignUpReq;
import sodam.domain.auth.presentation.dto.req.UserSignUpReq;
import sodam.domain.auth.presentation.dto.res.TokenRes;
import sodam.domain.auth.service.AuthService;
import sodam.global.response.Response;
import sodam.global.response.ResponseData;

@Tag(name = "Auth", description = "Auth Api")
@RestController
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @Operation(description = "회원가입")
    @PostMapping("/sign_up")
    public Response signUp(
            @RequestBody @Valid UserSignUpReq userSignUpReq
            ){
        return authService.signUp(userSignUpReq);
    }

    @Operation(description = "장사")
    @PostMapping("/sign_up/seller")
    public Response signUpSeller(
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
