package hackers.ground.sodam.global.error.custom.auth;

import hackers.ground.sodam.global.error.exception.BusinessException;
import hackers.ground.sodam.global.error.exception.StatusEnum;

public class InvalidTokenException extends BusinessException {

    public static final BusinessException EXCEPTION = new InvalidTokenException();

    public InvalidTokenException(){
        super(StatusEnum.INVALID_TOKEN);
    }

}