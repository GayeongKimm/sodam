package hackers.ground.sodam.global.error.custom.member;

import hackers.ground.sodam.global.error.exception.BusinessException;
import hackers.ground.sodam.global.error.exception.StatusEnum;

public class MemberNotCoincideException extends BusinessException {
    public static final BusinessException EXCEPTION = new MemberNotCoincideException();

    public MemberNotCoincideException() {super(StatusEnum.MEMBER_NOT_COINCIDE);}
}
