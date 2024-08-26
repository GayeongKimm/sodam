package sodam.global.error.custom.auth;

import sodam.global.error.exception.BusinessException;
import sodam.global.error.exception.StatusEnum;

public class EncryptException extends BusinessException {
    public static final BusinessException EXCEPTION = new EncryptException();

    public EncryptException() {
        super(StatusEnum.INTERNAL_SERVER_ERROR);
    }
}
