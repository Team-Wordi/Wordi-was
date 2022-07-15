package was.example.infrastructure.Read;

import was.common.exception.EntityNotFoundException;
import was.example.domain.Partner;
import was.example.domain.PartnerReader;
import was.example.infrastructure.PartnerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PartnerReadImpl implements PartnerReader {
    private final PartnerRepository partnerRepository;

    @Override
    public Partner getPartner(Long partnerId) {
        return partnerRepository.findById(partnerId)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Partner getPartner(String partnerToken) {
        return partnerRepository.findByPartnerToken(partnerToken)
                .orElseThrow(EntityNotFoundException::new);
    }
}
