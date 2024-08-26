package sodam.global.error.custom.auth;

import sodam.global.error.exception.BusinessException;
import sodam.global.error.exception.StatusEnum;

public class WrongPasswordException extends BusinessException {

    public static final BusinessException EXCEPTION = new WrongPasswordException();

    public WrongPasswordException(){
        super(StatusEnum.WRONG_PASSWORD);
    }

}

