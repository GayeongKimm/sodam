package sodam.global.error.custom.member;

import sodam.global.error.exception.BusinessException;
import sodam.global.error.exception.StatusEnum;

public class MemberNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new MemberNotFoundException();

    public MemberNotFoundException() {
        super(StatusEnum.MEMBER_NOT_FOUND);
    }
}
