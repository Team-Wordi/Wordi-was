package was.common.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NoticeClassification {
    USER("유저"),
    MENTOR("멘토");

    private final String value;

}
