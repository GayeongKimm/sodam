package hackers.ground.sodam.global.error.custom.auth;

import hackers.ground.sodam.global.error.exception.BusinessException;
import hackers.ground.sodam.global.error.exception.StatusEnum;

public class ExpiredTokenException extends BusinessException {

    public static final BusinessException EXCEPTION = new ExpiredTokenException();

    public ExpiredTokenException() {
        super(StatusEnum.EXPIRED_TOKEN);
    }
}
