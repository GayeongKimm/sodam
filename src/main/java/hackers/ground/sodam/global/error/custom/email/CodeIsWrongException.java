package hackers.ground.sodam.global.error.custom.email;

import hackers.ground.sodam.global.error.exception.BusinessException;
import hackers.ground.sodam.global.error.exception.StatusEnum;

public class CodeIsWrongException extends BusinessException {
    public static final BusinessException EXCEPTION = new CodeIsWrongException();

    public CodeIsWrongException() {
        super(StatusEnum.INVALID_AUTH_CODE);
    }
}
