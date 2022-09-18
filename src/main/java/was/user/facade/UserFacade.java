package was.user.facade;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import was.notification.application.NotificationService;
import was.user.application.UserService;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserFacade {

    public final UserService userService;

    public final NotificationService notificationService;

}
