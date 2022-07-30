package was.example.interfaces;

import org.springframework.web.bind.annotation.*;
import was.example.facade.PartnerFacade;
import was.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import was.example.interfaces.request.RegisterRequest;
import was.example.interfaces.response.RegisterResponse;

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

    }
}
