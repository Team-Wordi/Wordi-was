package was.mentoring.infrastructure;

import was.mentoring.domain.mentoring.Mentoring;
import was.mentoring.domain.mentoring.MentoringId;
import was.user.domain.mentor.Mentor;
import was.user.domain.user.User;

import java.util.Optional;

public interface MentoringJpaRepository {

    void save(Mentoring mentoring);
    Optional<Mentoring> findById(MentoringId mentoringId);
    Optional<Mentoring> findByMentorIdAndUserId(Mentor mentor, User user);
}
