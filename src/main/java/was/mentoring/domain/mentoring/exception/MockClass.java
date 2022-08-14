package was.mentoring.domain.mentoring.exception;

import was.common.exception.BaseException;
import was.common.response.ErrorCode;

public class MockClass extends BaseException {

    public MockClass() {
    }

    public MockClass(ErrorCode errorCode) {
        super(errorCode);
    }

    public MockClass(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public MockClass(String message, ErrorCode errorCode, Throwable cause) {
        super(message, errorCode, cause);
    }
}
