package hackers.ground.sodam.global.error.custom.enroll;


import hackers.ground.sodam.global.error.exception.BusinessException;
import hackers.ground.sodam.global.error.exception.StatusEnum;

public class ENROLL_NOT_FOUND extends BusinessException {
    public static final BusinessException EXCEPTION = new ENROLL_NOT_FOUND();

    public ENROLL_NOT_FOUND() {
        super(StatusEnum.ENROLL_NOT_FOUND);}

}
