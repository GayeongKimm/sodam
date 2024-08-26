package hackers.ground.sodam.global.error.custom.contest;

import hackers.ground.sodam.global.error.exception.StatusEnum;
import hackers.ground.sodam.global.error.exception.BusinessException;

public class ContestNotFound extends BusinessException {
    public static final BusinessException EXCEPTION = new ContestNotFound();

    public ContestNotFound(){
        super(StatusEnum.CONTEST_NOT_FOUND);
    }
}
