package hackers.ground.sodam.global.error.custom.member;

import hackers.ground.sodam.global.error.exception.BusinessException;
import hackers.ground.sodam.global.error.exception.StatusEnum;

public class MemberNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new MemberNotFoundException();

    public MemberNotFoundException() {
        super(StatusEnum.MEMBER_NOT_FOUND);
    }
}
