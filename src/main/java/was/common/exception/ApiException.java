package was.common.exception;

import was.common.exception.BaseException;
import was.common.response.ErrorCode;

public class ApiException extends BaseException {
    public ApiException() {
        super(ErrorCode.INVALID_LOGIN_TYPE);
    }

    public ApiException(String message) {
        super(message, ErrorCode.INVALID_LOGIN_TYPE);
    }
}
