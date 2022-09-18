package was.mentoring.domain.mentoring.interfaces;

import was.mentoring.domain.mentoring.MentoringId;
import was.user.domain.mentor.MentorId;
import was.user.domain.user.UserId;

import java.time.LocalDateTime;

public interface MentoringService {

    void apply(UserId userId, MentorId mentorId, long price, String text, LocalDateTime requestSchedule1, LocalDateTime requestSchedule2);
    void approved(UserId userId, MentoringId mentoringId, LocalDateTime selectedDateTime) throws Exception;
    void reject(UserId userId, MentoringId mentoringId, String message) throws Exception;
    void cancel(UserId userId, MentoringId mentoringId) throws Exception;
    void complete(MentoringId mentoringId) throws Exception;
}
