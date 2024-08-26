package hackers.ground.sodam.global.error.custom.auth;

import hackers.ground.sodam.global.error.exception.BusinessException;
import hackers.ground.sodam.global.error.exception.StatusEnum;

public class WrongTokenTypeException extends BusinessException {
    static final BusinessException EXCEPTION = new WrongTokenTypeException();

    private WrongTokenTypeException() {
        super(StatusEnum.WRONG_TOKEN_TYPE);
    }
}
