package was.common.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentProcess {
    WAIT("대기"),
    COMPLETION("완료"),
    CANCEL("취소"),
    REFUND("환불");

    private final String value;
}
