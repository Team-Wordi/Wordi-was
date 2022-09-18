package was.user.infrastructure.Read;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import was.user.domain.user.interfaces.UserRead;
import was.user.infrastructure.UserJpaRepository;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserReadImpl implements UserRead {

    private final UserJpaRepository userJpaRepository;
}
