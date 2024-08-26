package hackers.ground.sodam.global.error.custom.email;

import hackers.ground.sodam.global.error.exception.BusinessException;
import hackers.ground.sodam.global.error.exception.StatusEnum;

public class UnableToSendEmailException extends BusinessException {
    public static final BusinessException EXCEPTION = new UnableToSendEmailException();

    public UnableToSendEmailException() {
        super(StatusEnum.UNABLE_TO_SEND_EMAIL);
    }
}
