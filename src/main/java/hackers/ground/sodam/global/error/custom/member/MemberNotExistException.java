package hackers.ground.sodam.global.error.custom.member;

import hackers.ground.sodam.global.error.exception.BusinessException;
import hackers.ground.sodam.global.error.exception.StatusEnum;
public class MemberNotExistException extends BusinessException {
    public static final BusinessException EXCEPTION = new MemberNotExistException();

    public MemberNotExistException() {
        super(StatusEnum.MEMBER_NOT_EXISTS);
    }
}
