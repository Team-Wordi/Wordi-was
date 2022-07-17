package was.examplePakege.example.domain.partner.interfaces;

import was.examplePakege.example.domain.partner.Partner;

public interface PartnerStore {
    Partner store(Partner initPartner);

    // main / 레플리카 (따로 두는게 맞는 구현!)
    // JPA -> main -> 레플리카 조절을 할 수 있음
    // 백엔드 트래픽 가장 많이 발생할수 있는 케이스
    // 1. n+1 로직
    // 2. select 구문 (트래픽이 많이 듦)
    // DB를 따로 둠 -> 코드에서도 따로 구분해야함
    // @Transation(readOnly = true)
}
