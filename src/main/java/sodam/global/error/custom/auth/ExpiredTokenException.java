package sodam.global.error.custom.auth;

import sodam.global.error.exception.BusinessException;
import sodam.global.error.exception.StatusEnum;

public class ExpiredTokenException extends BusinessException {

    public static final BusinessException EXCEPTION = new ExpiredTokenException();

    public ExpiredTokenException() {
        super(StatusEnum.EXPIRED_TOKEN);
    }
}
