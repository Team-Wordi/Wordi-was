package was.user.domain.mentor;

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
public class MentorId implements ValueObject<MentorId> {

    private Long id;

    public MentorId(Long id) {
        this.id = id;
    }

    @Override
    public boolean sameValueAs(MentorId o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MentorId oId = o;
        return Objects.equals(id, oId.id);
    }

    @Override
    public String toString() {
        return String.valueOf(this.id);
    }
}