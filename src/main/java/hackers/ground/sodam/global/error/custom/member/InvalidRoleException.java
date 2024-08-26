package hackers.ground.sodam.global.error.custom.member;

import hackers.ground.sodam.global.error.exception.BusinessException;
import hackers.ground.sodam.global.error.exception.StatusEnum;

public class InvalidRoleException extends BusinessException {
    public static final BusinessException EXCEPTION = new InvalidRoleException();

    public InvalidRoleException() {
        super(StatusEnum.ID_ALREADY_EXIST);
    }
}