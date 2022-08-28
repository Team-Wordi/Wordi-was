package was.mentoring.interfaces.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MentoringRejectRequest {

    private long mentoringId;
    private String message;
}
