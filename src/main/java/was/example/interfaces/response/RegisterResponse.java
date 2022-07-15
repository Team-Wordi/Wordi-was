package was.example.interfaces.response;

import lombok.Getter;
import lombok.ToString;
import was.example.domain.Partner;
import was.example.domain.PartnerInfo;

@Getter
@ToString
public class RegisterResponse {

    private final String partnerToken;
    private final String partnerName;
    private final String businessNo;
    private final String email;
    private final Partner.Status status;

    public RegisterResponse(PartnerInfo partnerInfo) {
            this.partnerToken = partnerInfo.getPartnerToken();
            this.partnerName = partnerInfo.getPartnerName();
            this.businessNo = partnerInfo.getBusinessNo();
            this.email = partnerInfo.getEmail();
            this.status = partnerInfo.getStatus();
    }
}
