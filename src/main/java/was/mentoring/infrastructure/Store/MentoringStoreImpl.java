package was.mentoring.infrastructure.Store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import was.mentoring.domain.mentoring.Mentoring;
import was.mentoring.domain.mentoring.interfaces.MentoringStore;
import was.mentoring.infrastructure.MentoringJpaRepository;

@RequiredArgsConstructor
@Service
@Transactional
public class MentoringStoreImpl implements MentoringStore {

    private final MentoringJpaRepository mentoringJpaRepository;

    @Override
    public void save(Mentoring mentoring) {
        mentoringJpaRepository.save(mentoring);
    }
}
