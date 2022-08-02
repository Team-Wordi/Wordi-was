package was.common.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRole {
    NORMAL("일반"),
    ADMIN("관리자"),
    DORMANT("휴먼"),
    SUSPENDED("정지");

    private final String value;
}
