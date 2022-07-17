package was.examplePakege.example.domain.partner.interfaces;

import was.examplePakege.example.domain.partner.Partner;

public interface PartnerReader {
    Partner getPartner(Long partnerId);
    Partner getPartner(String partnerToken);
}
