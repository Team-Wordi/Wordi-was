package was.user.domain.mentor;



import was.common.entity.BaseStatus;
import was.common.entity.BaseTimeEntity;
import was.user.domain.user.User;

import javax.persistence.*;

public class MentorLike extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mentorLikeId")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "mentorId")
    private Mentor mentor;

    @Enumerated(EnumType.STRING)
    private BaseStatus status;

}
