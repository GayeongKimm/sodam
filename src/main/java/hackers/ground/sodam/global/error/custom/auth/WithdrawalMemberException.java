package hackers.ground.sodam.global.error.custom.auth;

import hackers.ground.sodam.global.error.exception.BusinessException;
import hackers.ground.sodam.global.error.exception.StatusEnum;

public class WithdrawalMemberException extends BusinessException {

    public static final BusinessException EXCEPTION = new WithdrawalMemberException();

    public WithdrawalMemberException(){
        super(StatusEnum.WITHDRAWAL_MEMBER);
    }

}
