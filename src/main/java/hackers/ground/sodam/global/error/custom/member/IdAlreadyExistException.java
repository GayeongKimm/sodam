package hackers.ground.sodam.global.error.custom.member;

import hackers.ground.sodam.global.error.exception.BusinessException;
import hackers.ground.sodam.global.error.exception.StatusEnum;

public class IdAlreadyExistException extends BusinessException {
    public static final BusinessException EXCEPTION = new IdAlreadyExistException();

    public IdAlreadyExistException() {
        super(StatusEnum.ID_ALREADY_EXIST);
    }
}
