package was.user.domain.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import was.common.entity.BaseTimeEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserNotification extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userNotificationId")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @Enumerated(EnumType.STRING)
    private NoticeClassification classification;

    @Column(nullable = false)
    private String content;

    @Column(columnDefinition = "DATETIME(3)")
    private LocalDateTime deletedAt;

    @Getter
    @AllArgsConstructor
    public enum NoticeClassification {
        USER("유저"),
        MENTOR("멘토");

        private final String value;
    }
}
