package was.mentoring.domain.mentoring;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import was.common.entity.BaseStatus;
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
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentorId")
    private Mentor mentor;

    @Column(nullable = false)
    private Long price;

    private String questions;

    @Column(nullable = false)
    private LocalDateTime requestSchedule1;

    private LocalDateTime requestSchedule2;

    private LocalDateTime selectedSchedule;

    private String refusalMessage;

    @Enumerated(EnumType.STRING)
    private MentoringProcess processStatus;

    @Enumerated(EnumType.STRING)
    private BaseStatus status;

    @Getter
    @AllArgsConstructor
    public enum MentoringProcess {
        WAITED("대기중"),
        CANCELED("취소"),
        DECISIONED("확정"),
        REFUELED("거절"),
        COMPLETED("완료");

        private final String value;
    }

}
