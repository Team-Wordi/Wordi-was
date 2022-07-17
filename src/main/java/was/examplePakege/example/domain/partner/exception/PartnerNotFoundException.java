package was.examplePakege.example.domain.partner.exception;

import was.common.exception.BaseException;
import was.common.response.ErrorCode;

public class PartnerNotFoundException extends BaseException {

    @Override
    public ErrorCode getErrorCode() {
        return super.getErrorCode();
    }

    public PartnerNotFoundException() {
        super();
    }

    public PartnerNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }

    public PartnerNotFoundException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public PartnerNotFoundException(String message, ErrorCode errorCode, Throwable cause) {
        super(message, errorCode, cause);
    }
}
