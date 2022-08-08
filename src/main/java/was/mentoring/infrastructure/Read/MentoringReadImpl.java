package was.mentoring.infrastructure.Read;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import was.mentoring.domain.mentoring.Mentoring;
import was.mentoring.domain.mentoring.MentoringId;
import was.mentoring.domain.mentoring.interfaces.MentoringRead;
import was.mentoring.infrastructure.MentoringJpaRepository;
import was.user.domain.mentor.Mentor;
import was.user.domain.user.User;

import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MentoringReadImpl implements MentoringRead {

    private final MentoringJpaRepository mentoringJpaRepository;

    @Override
    public Optional<Mentoring> findByMentorIdAndUserId(Mentor mentor, User user) {
        return mentoringJpaRepository.findByMentorIdAndUserId(mentor, user);
    }

    @Override
    public Optional<Mentoring> findById(MentoringId mentoringId) {
        return mentoringJpaRepository.findById(mentoringId);
    }
}
