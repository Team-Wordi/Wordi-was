package was.user.domain.user;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import was.common.entity.BaseStatus;
import was.common.entity.BaseTimeEntity;

import javax.persistence.*;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String nickname;

    private String refreshToken;

    private String fcmToken;

    private boolean isOAuth2;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private String likeNations;

    private String keywords;

    @Enumerated(EnumType.STRING)
    private BaseStatus status;

    @Getter
    @AllArgsConstructor
    public enum UserRole {
        NORMAL("일반"),
        ADMIN("관리자"),
        DORMANT("휴먼"),
        SUSPENDED("정지");

        private final String value;
    }

}


