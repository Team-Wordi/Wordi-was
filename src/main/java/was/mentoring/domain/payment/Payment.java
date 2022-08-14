package was.mentoring.domain.payment;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import was.common.entity.BaseTimeEntity;
import was.mentoring.domain.mentoring.Mentoring;
import was.user.domain.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymentId")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentoringId")
    private Mentoring mentoring;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @Column(nullable = false, unique = true)
    private String orderNumber;

    @Column(nullable = false)
    private Long price;

    private String depositor;

    private String bankCode;

    private String accountNumber;

    @Enumerated(EnumType.STRING)
    private PaymentProcess paymentStatus;

    @Column(columnDefinition = "DATETIME(3)")
    private LocalDateTime deletedAt;

    @Getter
    @AllArgsConstructor
    public enum PaymentProcess {
        WAITED("대기"),
        COMPLETED("완료"),
        CANCELED("취소"),
        REFUNDED("환불");
        // 취소와 환불은 같은개념이자 않나요?

        private final String value;
    }

}
