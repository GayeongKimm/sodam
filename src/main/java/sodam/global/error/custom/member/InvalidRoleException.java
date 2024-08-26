package sodam.global.error.custom.member;

import sodam.global.error.exception.BusinessException;
import sodam.global.error.exception.StatusEnum;

public class InvalidRoleException extends BusinessException {
    public static final BusinessException EXCEPTION = new InvalidRoleException();

    public InvalidRoleException() {
        super(StatusEnum.ID_ALREADY_EXIST);
    }
}