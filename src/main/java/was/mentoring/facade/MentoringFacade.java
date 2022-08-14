package was.mentoring.facade;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import was.mentoring.domain.mentoring.MentoringId;
import was.mentoring.domain.mentoring.interfaces.MentoringService;
import was.mentoring.interfaces.request.MentoringApplyRequest;
import was.notification.application.NotificationService;
import was.user.domain.mentor.Mentor;
import was.user.domain.mentor.MentorId;
import was.user.domain.user.User;
import was.user.domain.user.UserId;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class MentoringFacade {

    public final MentoringService mentoringService;
    public final NotificationService notificationService;

    public void apply(MentorId mentorId, UserId userId, long price, String questions, LocalDateTime requestSchedule1, LocalDateTime requestSchedule2) {
        mentoringService.apply(userId, mentorId, price, questions, requestSchedule1, requestSchedule2);
        //todo 추후 firebase Notification 개발 완료시 변경 예정 + Event Driven 교체 필요
        notificationService.sendEmail("userEmail", "멘토링 신청", "***님이 멘토링 신청을 하였습니다.");
    }

    public void approved(UserId userId, MentoringId mentoringId, LocalDateTime selectedDateTime) throws Exception {
        mentoringService.approved(userId, mentoringId, selectedDateTime);
        //todo 추후 firebase Notification 개발 완료시 변경 예정 + Event Driven 교체 필요
        notificationService.sendEmail("userEmail", "멘토링 승락", "***님과의 멘토링이 매칭되었습니다.");
    }

    public void reject(UserId userId, MentoringId mentoringId, String message) throws Exception {
        mentoringService.reject(userId, mentoringId, message);
        //todo 추후 firebase Notification 개발 완료시 변경 예정 + Event Driven 교체 필요
        notificationService.sendEmail("userEmail", "멘토링 거절", "***님과의 멘토링이 거절 되었습니다..");
    }

    public void cancel(UserId userId, MentoringId mentoringId) throws Exception {
        mentoringService.cancel(userId, mentoringId);
        //todo 추후 firebase Notification 개발 완료시 변경 예정 + Event Driven 교체 필요
        notificationService.sendEmail("userEmail", "멘토링 예약 취소", "***님과의 멘토링이 예약취소 되었습니다..");
    }

    public void completed(MentoringId mentoringId) throws Exception {
        mentoringService.complete(mentoringId);
        //todo 추후 firebase Notification 개발 완료시 변경 예정 + Event Driven 교체 필요
        notificationService.sendEmail("userEmail", "멘토링 거래 완료", "***님과의 멘토링이 완료되었습니다.");
    }
}
