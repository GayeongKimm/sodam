package sodam.global.error.custom.contest;

import sodam.global.error.exception.BusinessException;
import sodam.global.error.exception.StatusEnum;

public class ContestNotFound extends BusinessException {
    public static final BusinessException EXCEPTION = new ContestNotFound();

    public ContestNotFound(){
        super(StatusEnum.CONTEST_NOT_FOUND);
    }
}
