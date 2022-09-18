package was.common.exception;

import was.common.response.ErrorCode;

public class InvalidJwtException extends BaseException{

    public InvalidJwtException() {
        super(ErrorCode.INVALID_JWT_ERROR);
    }

    public InvalidJwtException(String message) {
        super(message, ErrorCode.INVALID_JWT_ERROR);
    }
}
