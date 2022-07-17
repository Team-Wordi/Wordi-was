package was.examplePakege.example.domain.partner;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
/*
해당 Class는 Partner Domain에 포함시킬지 고민 필요
 */
@Getter
@Builder
@ToString
public class PartnerCommand {
    private final String partnerName;
    private final String businessNo;
    private final String email;

    public Partner toEntity() {
        return Partner.builder()
                .partnerName(partnerName)
                .businessNo(businessNo)
                .email(email)
                .build();
    }
}
