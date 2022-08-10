package was.mentoring.domain.mentoring.interfaces;

import was.mentoring.domain.mentoring.Mentoring;
import was.mentoring.domain.mentoring.MentoringId;
import was.mentoring.interfaces.response.MentoringListResponse;
import was.user.domain.mentor.Mentor;
import was.user.domain.mentor.MentorId;
import was.user.domain.user.User;

import java.util.List;
import java.util.Optional;

public interface MentoringRead {

    Optional<Mentoring> findByMentorIdAndUserId(Mentor mentor, User user);
    Optional<Mentoring> findById(MentoringId mentoringId);
    List<MentoringListResponse> findAllByMentorId(MentorId mentorId, boolean sorted);
}
