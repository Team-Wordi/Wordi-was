package was.user.infrastructure.Store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import was.user.domain.user.interfaces.UserStore;
import was.user.infrastructure.UserJpaRepository;

@RequiredArgsConstructor
@Service
@Transactional
public class UserStoreImpl implements UserStore {

    private final UserJpaRepository userJpaRepository;

}
