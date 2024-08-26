package sodam.global.error.custom.member;

import sodam.global.error.exception.BusinessException;
import sodam.global.error.exception.StatusEnum;

public class IdAlreadyExistException extends BusinessException {
    public static final BusinessException EXCEPTION = new IdAlreadyExistException();

    public IdAlreadyExistException() {
        super(StatusEnum.ID_ALREADY_EXIST);
    }
}
