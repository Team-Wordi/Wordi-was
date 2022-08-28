package was.mentoring.interfaces.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import was.mentoring.interfaces.model.MentoringListVO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@NoArgsConstructor
public class MentoringListResponse {

    private Long mentoringId;
    private String status;
    private String requestSchedule1;
    private String selectedSchedule;
    private Long matchingUserId;
    private String matchingUserName;

    public static MentoringListResponse from(MentoringListVO mentoringListVO) {
        MentoringListResponse mentoringListResponse = new MentoringListResponse();
        mentoringListResponse.mentoringId = mentoringListVO.getMentoringId().getId();
        mentoringListResponse.status = mentoringListVO.getStatus().getValue();
        mentoringListResponse.requestSchedule1 = mentoringListVO.getRequestSchedule1().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        mentoringListResponse.selectedSchedule = mentoringListVO.getSelectedSchedule().format(DateTimeFormatter.ofPattern("yyyyMMdd"));;
        mentoringListResponse.matchingUserId = mentoringListVO.getMatchingUserId().getId();
        mentoringListResponse.matchingUserName = mentoringListVO.getMatchingUserName();
        return mentoringListResponse;
    }
}
