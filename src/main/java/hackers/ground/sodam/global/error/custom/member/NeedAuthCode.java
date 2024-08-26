package hackers.ground.sodam.global.error.custom.member;

import hackers.ground.sodam.global.error.exception.BusinessException;
import hackers.ground.sodam.global.error.exception.StatusEnum;

public class NeedAuthCode extends BusinessException {
    public static final BusinessException EXCEPTION = new NeedAuthCode();

    public NeedAuthCode() {
        super(StatusEnum.MISSING_AUTH_CODE);
    }
}
