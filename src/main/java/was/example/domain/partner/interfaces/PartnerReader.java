package was.example.domain.partner.interfaces;

import was.example.domain.partner.Partner;

public interface PartnerReader {
    Partner getPartner(Long partnerId);
    Partner getPartner(String partnerToken);
}
