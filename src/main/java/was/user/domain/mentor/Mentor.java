package was.user.domain.mentor;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import was.common.entity.BaseTimeEntity;
import was.user.domain.user.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Mentor extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mentorId")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    private String profileImageUrl;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private String introductionTitle;

    @Column(nullable = false)
    private String introduction;

    @Column(nullable = false)
    private String entryCertificationName;

    @Column(nullable = false)
    private String entryCertificationUrl;

    @Column(nullable = false)
    private String visaCertificationName;

    @Column(nullable = false)
    private String visaCertificationUrl;

    @Column(nullable = false)
    private String openChatUrl;

    @Enumerated(EnumType.STRING)
    private MentorRole role;

    private String schedules;

    private String keywords;

    @Column(columnDefinition = "DATETIME(3)")
    private LocalDateTime deletedAt;

    @Getter
    @AllArgsConstructor
    public enum MentorRole {
        CERTIFIED("인증"),
        UNCERTIFIED("비인증");

        private final String value;

    }

}
