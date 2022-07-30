package was.example.domain.partner.interfaces;

import was.example.domain.partner.PartnerCommand;
import was.example.domain.partner.PartnerInfo;

public interface PartnerService {
    PartnerInfo registerPartner(PartnerCommand command);
}
