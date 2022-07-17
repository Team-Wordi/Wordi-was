package was.examplePakege.example.domain.partner.interfaces;

import was.examplePakege.example.domain.partner.PartnerCommand;
import was.examplePakege.example.domain.partner.PartnerInfo;

public interface PartnerService {
    PartnerInfo registerPartner(PartnerCommand command);
}
