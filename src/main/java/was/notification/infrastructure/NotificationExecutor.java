package was.notification.infrastructure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import was.notification.application.NotificationService;

@Slf4j
@Component
public class NotificationExecutor implements NotificationService {

    @Override
    public void sendEmail(String email, String title, String description) {
        log.info("sendEmail");
    }
}
