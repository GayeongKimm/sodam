package sodam.global.error.custom.member;

import sodam.global.error.exception.BusinessException;
import sodam.global.error.exception.StatusEnum;

public class NeedAuthCode extends BusinessException {
    public static final BusinessException EXCEPTION = new NeedAuthCode();

    public NeedAuthCode() {
        super(StatusEnum.MISSING_AUTH_CODE);
    }
}
