package was.mentoring.interfaces;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import was.common.response.CommonResponse;
import was.mentoring.domain.mentoring.MentoringId;
import was.mentoring.domain.mentoring.interfaces.MentoringRead;
import was.mentoring.facade.MentoringFacade;
import was.mentoring.interfaces.request.MentoringApplyRequest;
import was.mentoring.interfaces.request.MentoringApprovedRequest;
import was.mentoring.interfaces.request.MentoringCancelRequest;
import was.mentoring.interfaces.request.MentoringRejectRequest;
import was.user.domain.mentor.MentorId;
import was.user.domain.user.UserId;

import java.time.LocalDateTime;

@RestController
@Slf4j
@RequiredArgsConstructor
@MentoringV1RestController
public class MentoringController {

    private final MentoringFacade mentoringFacade;
    private final MentoringRead mentoringRead;

    @GetMapping("/list")
    @Transactional
    public CommonResponse list(@RequestParam long userId,
                               @RequestParam boolean sorted){
        //멘토 찾기
        return CommonResponse.success(mentoringRead.findAllByMentorId(new MentorId(1L), sorted));
    }

    @GetMapping("/list/{id}")
    @Transactional
    public CommonResponse getPost(@RequestParam long userId, @PathVariable String id) {
        return CommonResponse.success(null);
    }

    @PostMapping("")
    @Transactional
    public CommonResponse apply(@RequestBody MentoringApplyRequest mentoringApplyRequest,
                                //todo 추후 Spring Security 변경예정
                                @RequestParam long userId) {
        mentoringFacade.apply(
                new MentorId(mentoringApplyRequest.getMentorId()),
                new UserId(userId),
                mentoringApplyRequest.getPrice(),
                mentoringApplyRequest.getQuestions(),
                mentoringApplyRequest.getRequestSchedule1(),
                mentoringApplyRequest.getRequestSchedule2()
                );
        return CommonResponse.success(null);
    }

    @PutMapping("/approved")
    @Transactional
    public CommonResponse approved(@RequestBody MentoringApprovedRequest mentoringApprovedRequest,
                                   @RequestParam long userId) throws Exception {
        mentoringFacade.approved(
                new UserId(userId),
                new MentoringId(mentoringApprovedRequest.getMentoringId()),
                LocalDateTime.parse(mentoringApprovedRequest.getSelectedDateTime())
        );
        return CommonResponse.success(null);
    }

    @DeleteMapping("/cancel")
    @Transactional
    public CommonResponse cancel(@RequestBody MentoringCancelRequest mentoringCancelRequest,
                                 @RequestParam long userId) throws Exception {
        mentoringFacade.cancel(
                new UserId(userId),
                new MentoringId(mentoringCancelRequest.getMentoringId())
        );
        return CommonResponse.success(null);
    }

    @DeleteMapping("/reject")
    @Transactional
    public CommonResponse reject(@RequestBody MentoringRejectRequest mentoringRejectRequest,
                                 @RequestParam long userId) throws Exception {
        mentoringFacade.reject(
                new UserId(userId),
                new MentoringId(mentoringRejectRequest.getMentoringId()),
                mentoringRejectRequest.getMessage()
        );
        return CommonResponse.success(null);
    }
}
