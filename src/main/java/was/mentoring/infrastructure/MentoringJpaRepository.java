package was.mentoring.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import was.mentoring.domain.mentoring.Mentoring;
import was.mentoring.domain.mentoring.MentoringId;
import was.user.domain.mentor.Mentor;
import was.user.domain.user.User;

import java.util.Optional;

public interface MentoringJpaRepository extends JpaRepository<Mentoring, MentoringId> {
    Optional<Mentoring> findByMentorIdAndUserId(Mentor mentor, User user);
}
