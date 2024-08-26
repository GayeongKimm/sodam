package sodam.global.error.custom.member;

import sodam.global.error.exception.BusinessException;
import sodam.global.error.exception.StatusEnum;

public class MemberNotExistException extends BusinessException {
    public static final BusinessException EXCEPTION = new MemberNotExistException();

    public MemberNotExistException() {
        super(StatusEnum.MEMBER_NOT_EXISTS);
    }
}
