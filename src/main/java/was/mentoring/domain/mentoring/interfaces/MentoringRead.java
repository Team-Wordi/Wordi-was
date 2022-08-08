package was.mentoring.domain.mentoring.interfaces;

import was.mentoring.domain.mentoring.Mentoring;
import was.mentoring.domain.mentoring.MentoringId;
import was.user.domain.mentor.Mentor;
import was.user.domain.user.User;

import java.util.Optional;

public interface MentoringRead {

    Optional<Mentoring> findByMentorIdAndUserId(Mentor mentor, User user);
    Optional<Mentoring> findById(MentoringId mentoringId);
}
