package was.mentoring.interfaces.model;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import was.mentoring.domain.mentoring.Mentoring;
import was.mentoring.domain.mentoring.MentoringId;
import was.user.domain.user.UserId;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class MentoringListVO {

    private MentoringId mentoringId;
    private Mentoring.MentoringProcess status;
    private LocalDateTime requestSchedule1;
    private LocalDateTime selectedSchedule;
    private UserId matchingUserId;
    private String matchingUserName;


    @QueryProjection
    public MentoringListVO(MentoringId mentoringId, Mentoring.MentoringProcess status, LocalDateTime requestSchedule1, LocalDateTime selectedSchedule, UserId matchingUserId, String matchingUserName) {
        this.mentoringId = mentoringId;
        this.status = status;
        this.requestSchedule1 = requestSchedule1;
        this.selectedSchedule = selectedSchedule;
        this.matchingUserId = matchingUserId;
        this.matchingUserName = matchingUserName;
    }
}

