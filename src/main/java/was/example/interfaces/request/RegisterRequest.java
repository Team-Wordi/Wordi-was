package was.example.interfaces.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import was.example.domain.partner.PartnerCommand;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
public class RegisterRequest {

    @NotEmpty(message = "partnerName 는 필수값입니다")
    private String partnerName;

    @NotEmpty(message = "businessNo 는 필수값입니다")
    private String businessNo;

    @Email(message = "email 형식에 맞아야 합니다")
    @NotEmpty(message = "email 는 필수값입니다")
    private String email;

    public PartnerCommand toCommand() {
        return PartnerCommand.builder()
                .partnerName(partnerName)
                .businessNo(businessNo)
                .email(email)
                .build();
    }
}
