package hackers.ground.sodam.global.error.custom.auth;

import hackers.ground.sodam.global.error.exception.BusinessException;
import hackers.ground.sodam.global.error.exception.StatusEnum;

public class RefreshTokenException extends BusinessException {

    public static final BusinessException EXCEPTION = new RefreshTokenException();

    public RefreshTokenException(){
        super(StatusEnum.REFRESH_TOKEN_NOT_FOUND);
    }

}
