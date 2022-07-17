package was.examplePakege.example.interfaces;

import org.springframework.web.bind.annotation.*;
import was.examplePakege.example.facade.PartnerFacade;
import was.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import was.examplePakege.example.interfaces.request.RegisterRequest;
import was.examplePakege.example.interfaces.response.RegisterResponse;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/partners")
public class PartnerApiController {
    private final PartnerFacade partnerFacade;

    @PostMapping
    public CommonResponse registerPartner(
            @PathVariable()
            @RequestParam()
            @RequestBody @Valid RegisterRequest request) {
        var command = request.toCommand();
        var partnerInfo = partnerFacade.registerPartner(command);
        var response = new RegisterResponse(partnerInfo);
        return CommonResponse.success(response);

        // @Transation
        // 나누는 타이밍이 con ? -> facade ?
        // 객체지향 --> 의존성을 줄이는게 목표?
        // DDD -> 도메인이 주인외되고 로직을 짜야하는데
        // Serivce layer 겹치는게 있다보니 서로 의존성이 생긴다
        // 풀기위해 facade

        // request -> 웹 -> 같이 수정 -> 같이 배포
        // request -> app -> 업데이틑 안하면 -> 버그남
        // app -> 강제 업데이트를 치면 되는데...
        // 결론적으로는 구버젼 호환 중요함!
    }
}
