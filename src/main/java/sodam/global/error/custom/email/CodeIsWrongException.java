package sodam.global.error.custom.email;

import sodam.global.error.exception.BusinessException;
import sodam.global.error.exception.StatusEnum;

public class CodeIsWrongException extends BusinessException {
    public static final BusinessException EXCEPTION = new CodeIsWrongException();

    public CodeIsWrongException() {
        super(StatusEnum.INVALID_AUTH_CODE);
    }
}
