package sodam.global.error.custom.member;

import sodam.global.error.exception.BusinessException;
import sodam.global.error.exception.StatusEnum;

public class PermissionDeniedException extends BusinessException {
    public static final BusinessException EXCEPTION = new PermissionDeniedException();

    public PermissionDeniedException() {
        super(StatusEnum.PERMISSION_DENIED);
    }
}

