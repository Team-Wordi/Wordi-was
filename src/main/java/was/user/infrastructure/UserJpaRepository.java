package was.user.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import was.user.domain.user.User;
import was.user.domain.user.UserId;

public interface UserJpaRepository extends JpaRepository<User, UserId> {
}


