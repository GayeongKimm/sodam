package sodam.domain.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sodam.domain.auth.presentation.dto.req.SignInReq;
import sodam.domain.auth.presentation.dto.req.SignUpReq;
import sodam.domain.auth.presentation.dto.req.UserSignUpReq;
import sodam.domain.auth.presentation.dto.res.TokenRes;
import sodam.domain.user.entity.BuyerEntity;
import sodam.domain.user.entity.SellerEntity;
import sodam.domain.user.entity.UserEntity;
import sodam.domain.user.enums.UserCategory;
import sodam.domain.user.enums.UserState;
import sodam.domain.user.repository.BuyerRepository;
import sodam.domain.user.repository.SellerRepository;
import sodam.domain.user.repository.UserRepository;
import sodam.global.error.custom.auth.WrongPasswordException;
import sodam.global.error.custom.email.EmailAlreadyExistsException;
import sodam.global.error.custom.member.IdAlreadyExistException;
import sodam.global.error.custom.member.MemberNotFoundException;
import sodam.global.infra.jwt.JwtProvider;
import sodam.global.response.Response;
import sodam.global.response.ResponseData;

@Component
@RequiredArgsConstructor
public class AuthService {
    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;
    private final SellerRepository sellerRepository;
    private final BuyerRepository buyerRepository;

    @Transactional(rollbackFor = Exception.class)
    public Response signUp(UserSignUpReq userSignUpReq) {
        if (userRepository.existsByUserEmail(userSignUpReq.memberEmail())){
            throw EmailAlreadyExistsException.EXCEPTION;
        }

        if (userRepository.existsByUserId(userSignUpReq.memberId()))
            throw IdAlreadyExistException.EXCEPTION;

        UserEntity userEntity = userRepository.save(UserEntity
                .builder()
                .userId(userSignUpReq.memberId())
                .userName(userSignUpReq.memberName())
                .userEmail(userSignUpReq.memberEmail())
                .userPassword(new BCryptPasswordEncoder().encode(userSignUpReq.memberPassword()))
                .userCategory(UserCategory.BUYER)
                .userState(UserState.ACTIVE)
                .build());

        buyerRepository.save(BuyerEntity
                .builder()
                .userEntity(userEntity)
                .phoneNum(userSignUpReq.memberPhoneNum())
                .address(userSignUpReq.memberAddress())
                .build());

        return Response.of(HttpStatus.OK, "회원가입 성공");
    }

    @Transactional(rollbackFor = Exception.class)
    public Response signUpSeller(SignUpReq signUpReq) {
        if (userRepository.existsByUserEmail(signUpReq.memberEmail())){
            throw EmailAlreadyExistsException.EXCEPTION;
        }

        if (userRepository.existsByUserId(signUpReq.memberId()))
            throw IdAlreadyExistException.EXCEPTION;

        UserEntity userEntity = userRepository.save(UserEntity
                .builder()
                .userId(signUpReq.memberId())
                .userName(signUpReq.memberName())
                .userEmail(signUpReq.memberEmail())
                .userPassword(new BCryptPasswordEncoder().encode(signUpReq.memberPassword()))
                .userCategory(UserCategory.SELLER)
                .userState(UserState.ACTIVE)
                .build());

        sellerRepository.save(SellerEntity
                .builder()
                .userEntity(userEntity)
                .openDate(signUpReq.openDate())
                .sellerNum(signUpReq.sellerNum())
                .phoneNum(signUpReq.phoneNum())
                .farmName(signUpReq.farmName())
                .farmAdress(signUpReq.farmAdress())
                .account(signUpReq.account())
                .num(signUpReq.num())
                .build());
        return Response.of(HttpStatus.OK, "회원가입 성공");
    }

    @Transactional(rollbackFor = Exception.class)
    public ResponseData<TokenRes> signIn(SignInReq signInReq){
        UserEntity user = userRepository.findByUserId(signInReq.memberId());

        if(user == null || user.getUserState().equals(UserState.DELETED)) {
            throw MemberNotFoundException.EXCEPTION;
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (!encoder.matches(signInReq.memberPassword(), user.getUserPassword())) {
            throw WrongPasswordException.EXCEPTION;
        }

        return ResponseData.of(HttpStatus.OK, "로그인 성공", jwtProvider.generateToken(signInReq.memberId(), user.getUserState()));
    }
}
