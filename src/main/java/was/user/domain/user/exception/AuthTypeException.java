package was.user.domain.user.exception;

import was.common.exception.BaseException;
import was.common.response.ErrorCode;

public class AuthTypeException extends BaseException {

    public AuthTypeException() {
        super(ErrorCode.INVALID_LOGIN_TYPE);
    }

    public AuthTypeException(String message) {
        super(message, ErrorCode.INVALID_LOGIN_TYPE);
    }
}

