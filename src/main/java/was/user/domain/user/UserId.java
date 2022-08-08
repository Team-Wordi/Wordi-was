package was.user.domain.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import was.common.entity.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Getter
@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
public class UserId implements ValueObject<UserId> {

    private Long id;

    public UserId(Long id) {
        this.id = id;
    }

    @Override
    public boolean sameValueAs(UserId o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserId oId = o;
        return Objects.equals(id, oId.id);
    }

    @Override
    public String toString() {
        return String.valueOf(this.id);
    }
}