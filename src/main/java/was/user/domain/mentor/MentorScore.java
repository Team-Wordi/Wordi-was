package was.user.domain.mentor;


import was.common.entity.BaseTimeEntity;
import was.user.domain.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

public class MentorScore extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mentorScoreId")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "mentorId")
    private Mentor mentor;

    @Column(nullable = false)
    private Integer score;

    @Column(columnDefinition = "DATETIME(3)")
    private LocalDateTime deletedAt;

}
