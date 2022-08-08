package was.mentoring.domain.mentoring;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import was.common.entity.BaseTimeEntity;
import was.user.domain.mentor.Mentor;
import was.user.domain.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Mentoring extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mentoringId")
    private MentoringId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentorId")
    private Mentor mentor;

    @Column(nullable = false)
    private Long price;

    private String text;

    @Column(nullable = false)
    private LocalDateTime requestSchedule1;

    private LocalDateTime requestSchedule2;

    private LocalDateTime selectedSchedule;

    private String refusalMessage;

    @Enumerated(EnumType.STRING)
    private MentoringProcess status;

    @Getter
    @AllArgsConstructor
    public enum MentoringProcess {
        WAITED("대기중"),
        CANCELED("취소"), // 거절과 취소는 같은 맥락?
        DECISIONED("확정"),
        REFUELED("거절"),
        COMPLETED("완료");

        private final String value;
    }

    public Mentoring(User user, Mentor mentor, Long price, String text, LocalDateTime requestSchedule1, LocalDateTime requestSchedule2, LocalDateTime selectedSchedule, String refusalMessage, MentoringProcess status) {
        this.user = user;
        this.mentor = mentor;
        this.price = price;
        this.text = text;
        this.requestSchedule1 = requestSchedule1;
        this.requestSchedule2 = requestSchedule2;
        this.selectedSchedule = selectedSchedule;
        this.refusalMessage = refusalMessage;
        this.status = status;
    }

    public static Mentoring newOne(User user, Mentor mentor, Long price, String text, LocalDateTime requestSchedule1, LocalDateTime requestSchedule2) {
        return new Mentoring(
                user,
                mentor,
                price,
                text,
                requestSchedule1,
                requestSchedule2,
                null,
                null,
                MentoringProcess.WAITED
        );
    }

    public void approved(LocalDateTime selectedSchedule) {
        this.status = MentoringProcess.DECISIONED;
        this.selectedSchedule = selectedSchedule;
    }

    public void canceled(String refusalMessage) {
        this.status = MentoringProcess.CANCELED;
        this.refusalMessage = refusalMessage;
    }

    public void completed() {
        this.status = MentoringProcess.COMPLETED;
    }

}
