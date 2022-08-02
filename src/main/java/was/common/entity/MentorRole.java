package was.common.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MentorRole {
    CERTIFIED("인증"),
    UNCERTIFIED("비인증");

    private final String value;

}
