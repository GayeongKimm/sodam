package sodam.global.error.custom.auth;

import sodam.global.error.exception.BusinessException;
import sodam.global.error.exception.StatusEnum;

public class UnableToSendEmailException extends BusinessException {
    public static final BusinessException EXCEPTION = new UnableToSendEmailException();

    public UnableToSendEmailException(){
        super(StatusEnum.UNABLE_TO_SEND_EMAIL);
    }
}
