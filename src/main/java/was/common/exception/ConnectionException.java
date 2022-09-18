package was.common.exception;

import was.common.exception.BaseException;
import was.common.response.ErrorCode;

public class ConnectionException extends BaseException {

    public ConnectionException() {
        super(ErrorCode.CONNECTION_ERROR);
    }

    public ConnectionException(String message) {
        super(message, ErrorCode.CONNECTION_ERROR);
    }
}
