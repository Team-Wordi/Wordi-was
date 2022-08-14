package was.mentoring.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import was.mentoring.domain.mentoring.Mentoring;
import was.mentoring.domain.mentoring.MentoringId;
import was.mentoring.domain.mentoring.interfaces.MentoringRead;
import was.mentoring.domain.mentoring.interfaces.MentoringStore;
import was.mentoring.domain.mentoring.interfaces.MentoringService;
import was.mentoring.domain.mentoring.exception.MentoringNotFoundException;
import was.user.domain.mentor.Mentor;
import was.user.domain.mentor.MentorId;
import was.user.domain.user.User;
import was.user.domain.user.UserId;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class MentoringServiceImpl implements MentoringService {

    public final MentoringStore mentoringStore;
    public final MentoringRead mentoringRead;

    @Override
    @Transactional
    public void apply(UserId userId, MentorId mentorId, long price, String questions, LocalDateTime requestSchedule1, LocalDateTime requestSchedule2) {
        // todo User 도메인 구현시 조회로직 추가
        // todo mentor 도메인 구현시 조회로직 추가
        Optional<Mentoring> mentoring = mentoringRead.findByMentorIdAndUserId(new Mentor(new MentorId(1L)), new User(new UserId(1L)));
        if(mentoring.isEmpty()) {
            mentoringStore.save(Mentoring.newOne(
                    new User(new UserId(1L)),
                    new Mentor(new MentorId(1L)),
                    price,
                    questions,
                    requestSchedule1,
                    requestSchedule2
            ));
        }
    }

    @Override
    public void approved(UserId userId, MentoringId mentoringId, LocalDateTime selectedDateTime) {
        Mentoring mentoring = mentoringRead.findById(mentoringId).orElseThrow(MentoringNotFoundException::new);
        mentoring.approved(selectedDateTime);
        mentoringStore.save(mentoring);
    }

    @Override
    public void reject(UserId userId, MentoringId mentoringId, String message) {
        Mentoring mentoring = mentoringRead.findById(mentoringId).orElseThrow(MentoringNotFoundException::new);
        mentoring.canceled(message);
        mentoringStore.save(mentoring);
    }

    @Override
    public void cancel(UserId userId, MentoringId mentoringId) {
        Mentoring mentoring = mentoringRead.findById(mentoringId).orElseThrow(MentoringNotFoundException::new);
        mentoring.canceled(null);
        mentoringStore.save(mentoring);
    }

    @Override
    public void complete(MentoringId mentoringId) {
        Mentoring mentoring = mentoringRead.findById(mentoringId).orElseThrow(MentoringNotFoundException::new);
        mentoring.completed();
        mentoringStore.save(mentoring);
    }
}
