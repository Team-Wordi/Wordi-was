package was.mentoring.domain.mentoring.exception;

import was.common.exception.BaseException;
import was.common.response.ErrorCode;

public class MentoringNotFoundException extends BaseException {

    public MentoringNotFoundException() {
        super(ErrorCode.COMMON_ENTITY_NOT_FOUND);
    }

    public MentoringNotFoundException(String message) {
        super(message, ErrorCode.COMMON_ENTITY_NOT_FOUND);
    }
}
