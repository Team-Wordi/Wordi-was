package was.examplePakege.example.facade;

import org.springframework.transaction.annotation.Transactional;
import was.examplePakege.examplenotification.domain.NotificationService;
import was.examplePakege.example.domain.partner.PartnerCommand;
import was.examplePakege.example.domain.partner.PartnerInfo;
import was.examplePakege.example.domain.partner.PartnerService;
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

        // 거래를 만드는 기능이있다
        // 내거래 목록
        // method 네이밍 짓기도 어려움 (거래를 만들고 -> 내거래 list에 거래를 추가한다)
        // 스타트업 -> 가장 많이하는게 -> 로직 복잡하지 X -> 하나로 묶음
        // 계속 기능 추가 -> 수정 메서드 비대해짐 -> 바쁘다보니 -> 리펙토링 x -> 그대로 씀
        // 1. 처음부터 그냥 구분하지 -> 짧더라도..그게 맞다..그게나중에 관리하기 쉽다
        // 2. 굳이? 비대해지면 그때가서 하면되지..? (처음에는 개발쉬움 -> 리펙토링 시간을 따로 할애해야함 (리소스가 추가적으로 듦))

        notificationService.sendEmail(partnerInfo.getEmail(), "title", "description");
        // noti -> 안가도 상관 X
        // noti -> 못가면 -> 다 롤백 ? -> ? ? ?
        // EDA -> Service -> noti -> 전송 x -> 여기서는 event 등록 -> 끝
        // Pub?sub ->
        // 멤버 만들었다 ! -> 멤버 noti 서버에다가 -> 이벤트 등록 (A유조가 가입했으니 1번 디바이스에 노티를 보내)
        // 등록 완료! -> 나머지는 난 몰라~ 니가 알아서해
        // 멤버 noti 서버는 이 상황 구독하고있음 계속 -> 이벤트가 들어오면 -> 어! 들어왔네! -> 실행
        // 어?그럼 이거 서버가 뭐지 ? ->
        // String boot -> Spring Integration -> Spring localThread -> 단점 -> local -> 지금 서버가 죽으면 -> 안에들어있는 queue도 다 죽으
        // 데이터 유실되는것! -> noti -> 유실되도 상관 X
        // 중요한 데이터 -> MSA -> MSA 데이터 중요함 -> 유실 X
        // redis pub/sub, google cloud pub/sub, kafka pub/sub
        // noti -> 데이터가 유실 -> 상관 X
        // as-is -> notification table 진행해도 저도 괜찮음!
        // to-be -> 전환시점 상관 X
        // notificaiton table -> member 1개 -> member1명이 몇천개의 데이터를가질수있음
        // history join -> 카티션곱 -> 고민
        // 저는 제일 좋은방법이 -> spring batch 00:00 돌리기 -> noti가 1년이상 지난거? n일 이상? -> 지운다던지..... 나중에 생각해보는걸로!
        return partnerInfo;
    }
}
