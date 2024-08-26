package hackers.ground.sodam.domain.auth.service;

import hackers.ground.sodam.domain.auth.presentation.dto.req.UserSignUpReq;
import hackers.ground.sodam.domain.user.entity.BuyerEntity;
import hackers.ground.sodam.domain.user.entity.SellerEntity;
import hackers.ground.sodam.domain.user.repository.BuyerRepository;
import hackers.ground.sodam.domain.user.repository.SellerRepository;
import hackers.ground.sodam.global.error.custom.auth.WrongPasswordException;
import hackers.ground.sodam.global.error.custom.email.EmailAlreadyExistsException;
import hackers.ground.sodam.global.error.custom.member.IdAlreadyExistException;
import hackers.ground.sodam.global.error.custom.member.MemberNotFoundException;
import hackers.ground.sodam.global.infra.jwt.JwtProvider;
import hackers.ground.sodam.global.response.Response;
import hackers.ground.sodam.global.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import hackers.ground.sodam.domain.auth.presentation.dto.req.SignInReq;
import hackers.ground.sodam.domain.auth.presentation.dto.req.SignUpReq;
import hackers.ground.sodam.domain.auth.presentation.dto.res.TokenRes;
import hackers.ground.sodam.domain.user.entity.UserEntity;
import hackers.ground.sodam.domain.user.enums.UserCategory;
import hackers.ground.sodam.domain.user.enums.UserState;
import hackers.ground.sodam.domain.user.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class AuthService {
    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;
    private final SellerRepository sellerRepository;
    private final BuyerRepository buyerRepository;

    @Transactional(rollbackFor = Exception.class)
    public ResponseData<UserCategory> signUp(UserSignUpReq userSignUpReq) {
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

        return ResponseData.of(HttpStatus.OK, "회원가입 성공", UserCategory.BUYER);
    }

    @Transactional(rollbackFor = Exception.class)
    public ResponseData<UserCategory> signUpSeller(SignUpReq signUpReq) {
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
        return ResponseData.of(HttpStatus.OK, "회원가입 성공", UserCategory.SELLER);
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
