package sodam.global.error.custom.email;

import sodam.global.error.exception.BusinessException;
import sodam.global.error.exception.StatusEnum;

public class EmailAlreadyExistsException extends BusinessException {
    public static final BusinessException EXCEPTION = new EmailAlreadyExistsException();

    public EmailAlreadyExistsException() {
        super(StatusEnum.EMAIL_ALREADY_EXISTS);
    }
}
