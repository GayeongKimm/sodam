package sodam.global.error.custom.auth;

import sodam.global.error.exception.BusinessException;
import sodam.global.error.exception.StatusEnum;

public class WithdrawalMemberException extends BusinessException {

    public static final BusinessException EXCEPTION = new WithdrawalMemberException();

    public WithdrawalMemberException(){
        super(StatusEnum.WITHDRAWAL_MEMBER);
    }

}
