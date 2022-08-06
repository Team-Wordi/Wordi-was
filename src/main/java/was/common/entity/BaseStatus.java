package was.common.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BaseStatus {
    ACTIVE("활성화"),
    INACTIVE("비활성화");

    private final String value;
}
