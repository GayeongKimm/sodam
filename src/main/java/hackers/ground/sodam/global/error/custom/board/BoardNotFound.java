package hackers.ground.sodam.global.error.custom.board;

import hackers.ground.sodam.global.error.exception.BusinessException;
import hackers.ground.sodam.global.error.exception.StatusEnum;

public class BoardNotFound extends BusinessException {
    public static final BusinessException EXCEPTION = new BoardNotFound();

    public BoardNotFound(){
        super(StatusEnum.BOARD_NOT_FOUND);
    }
}
