package was.mentoring.interfaces.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class MentoringApprovedRequest {

    private long mentoringId;
    private String selectedDateTime;
}
