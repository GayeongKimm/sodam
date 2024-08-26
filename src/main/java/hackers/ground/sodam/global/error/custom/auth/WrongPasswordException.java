package hackers.ground.sodam.global.error.custom.auth;

import hackers.ground.sodam.global.error.exception.BusinessException;
import hackers.ground.sodam.global.error.exception.StatusEnum;

public class WrongPasswordException extends BusinessException {

    public static final BusinessException EXCEPTION = new WrongPasswordException();

    public WrongPasswordException(){
        super(StatusEnum.WRONG_PASSWORD);
    }

}

