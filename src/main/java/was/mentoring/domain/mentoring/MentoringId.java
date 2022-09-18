package was.mentoring.domain.mentoring;

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
public class MentoringId implements ValueObject<MentoringId> {

    private Long id;

    public MentoringId(Long id) {
        this.id = id;
    }

    @Override
    public boolean sameValueAs(MentoringId o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MentoringId oId = o;
        return Objects.equals(id, oId.id);
    }

    @Override
    public String toString() {
        return String.valueOf(this.id);
    }
}