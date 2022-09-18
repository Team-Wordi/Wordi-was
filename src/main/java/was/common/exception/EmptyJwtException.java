package was.common.exception;

import was.common.response.ErrorCode;

public class EmptyJwtException extends BaseException{

    public EmptyJwtException() {
        super(ErrorCode.EMPTY_JWT_ERROR);
    }

    public EmptyJwtException(String message) {
        super(message, ErrorCode.EMPTY_JWT_ERROR);
    }
}
