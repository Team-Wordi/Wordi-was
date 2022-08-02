package was.common.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MentoringProcess {
    WAIT("대기중"),
    CANCEL("취소"),
    DECISION("확정"),
    REFUSAL("거절"),
    COMPLETION("완료");

    private final String value;
}
