package hackers.ground.sodam.global.error.custom.member;

import hackers.ground.sodam.global.error.exception.BusinessException;
import hackers.ground.sodam.global.error.exception.StatusEnum;

public class PermissionDeniedException extends BusinessException {
    public static final BusinessException EXCEPTION = new PermissionDeniedException();

    public PermissionDeniedException() {
        super(StatusEnum.PERMISSION_DENIED);
    }
}

