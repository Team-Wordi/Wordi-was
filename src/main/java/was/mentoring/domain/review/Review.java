package was.mentoring.domain.review;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import was.common.entity.BaseStatus;
import was.common.entity.BaseTimeEntity;
import was.mentoring.domain.mentoring.Mentoring;
import was.user.domain.mentor.Mentor;
import was.user.domain.user.User;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reviewId")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    //멘토링 안에 멘토가 있는데 해당 엔티티를 맵핑할 필요가 있나요 ?
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentorId")
    private Mentor mentor;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentoringId")
    private Mentoring mentoring;

    @Column(nullable = false)
    private Integer score;

    @Column(nullable = false)
    private String content;

    // 해당 값은 필요없는것으로 보입니다.
    @Enumerated(EnumType.STRING)
    private BaseStatus status;


}
