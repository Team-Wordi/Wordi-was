package was.mentoring.infrastructure.Read;

import com.querydsl.jpa.JPQLQueryFactory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import was.mentoring.domain.mentoring.Mentoring;
import was.mentoring.domain.mentoring.MentoringId;
import was.mentoring.domain.mentoring.interfaces.MentoringRead;
import was.mentoring.infrastructure.MentoringJpaRepository;
import was.mentoring.interfaces.model.MentoringListVO;
import was.mentoring.interfaces.model.QMentoringListVO;
import was.mentoring.interfaces.response.MentoringListResponse;
import was.user.domain.mentor.Mentor;
import was.user.domain.mentor.MentorId;
import was.user.domain.user.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static was.mentoring.domain.mentoring.QMentoring.mentoring;


@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MentoringReadImpl implements MentoringRead {

    private final MentoringJpaRepository mentoringJpaRepository;
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<Mentoring> findByMentorIdAndUserId(Mentor mentor, User user) {
        return mentoringJpaRepository.findByMentorIdAndUserId(mentor, user);
    }

    @Override
    public Optional<Mentoring> findById(MentoringId mentoringId) {
        return mentoringJpaRepository.findById(mentoringId);
    }

    @Override
    public List<MentoringListResponse> findAllByMentorId(MentorId mentorId, boolean sorted) {
        if(sorted) {
            return findAllByMentorIdFromSorted(mentorId);
        }
        return findAllByMentorId(mentorId);
    }

    private List<MentoringListResponse> findAllByMentorIdFromSorted(MentorId mentorId) {
        List<MentoringListVO> mentoringListVOS = jpaQueryFactory
                .select(new QMentoringListVO(
                        mentoring.id,
                        mentoring.status,
                        mentoring.requestSchedule1,
                        mentoring.selectedSchedule,
                        mentoring.user.id,
                        mentoring.user.nickname
                ))
                .from(mentoring)
                .where(mentoring.mentor.id.eq(mentorId))
                .orderBy(mentoring.createdAt.desc())
                .fetch();
        return mentoringListVOS.stream().map(MentoringListResponse::from).collect(Collectors.toList());
    }

    private List<MentoringListResponse> findAllByMentorId(MentorId mentorId) {
        List<MentoringListVO> mentoringListVOS = jpaQueryFactory
                .select(new QMentoringListVO(
                        mentoring.id,
                        mentoring.status,
                        mentoring.requestSchedule1,
                        mentoring.selectedSchedule,
                        mentoring.user.id,
                        mentoring.user.nickname
                ))
                .from(mentoring)
                .where(mentoring.mentor.id.eq(mentorId))
                .fetch();
        return mentoringListVOS.stream().map(MentoringListResponse::from).collect(Collectors.toList());
    }
}
