package was.mentoring.interfaces.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import was.mentoring.domain.mentoring.Mentoring;
import was.user.domain.user.User;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class MentoringApplyRequest {

    private long mentorId;
    private long price;
    private String questions;
    private LocalDateTime requestSchedule1;
    private LocalDateTime requestSchedule2;
}
