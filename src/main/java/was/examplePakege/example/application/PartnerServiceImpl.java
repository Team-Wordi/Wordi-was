package was.examplePakege.example.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import was.examplePakege.example.domain.partner.*;
import was.examplePakege.example.domain.partner.interfaces.PartnerReader;
import was.examplePakege.example.domain.partner.interfaces.PartnerService;
import was.examplePakege.example.domain.partner.interfaces.PartnerStore;

@Slf4j
@Service
@RequiredArgsConstructor
public class PartnerServiceImpl implements PartnerService {
    private final PartnerStore partnerStore;
    private final PartnerReader partnerReader;

    @Override
    @Transactional
    public PartnerInfo registerPartner(PartnerCommand command) {
        var initPartner = command.toEntity();
        Partner partner = partnerStore.store(initPartner);
        return new PartnerInfo(partner);
    }
}
