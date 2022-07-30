package was.example.facade;

import org.springframework.transaction.annotation.Transactional;
import was.example.domain.partner.PartnerCommand;
import was.example.domain.partner.PartnerInfo;
import was.example.domain.partner.interfaces.PartnerService;
import was.examplePakege.examplenotification.domain.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PartnerFacade {
    private final PartnerService partnerService;
    private final NotificationService notificationService;

    @Transactional
    public PartnerInfo registerPartner(PartnerCommand command) {
        var partnerInfo = partnerService.registerPartner(command);

        notificationService.sendEmail(partnerInfo.getEmail(), "title", "description");

        return partnerInfo;
    }
}
