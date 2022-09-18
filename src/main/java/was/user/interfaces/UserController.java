package was.user.interfaces;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import was.common.response.CommonResponse;

@RestController
@Slf4j
@RequiredArgsConstructor
@UserV1RestController
public class UserController {

    @GetMapping("/profile/check-duplicate")
    public CommonResponse nicknameDuplicateCheck(@RequestParam String nickname){
        return CommonResponse.success(null);
    }

    @PostMapping("/account/sns-login")
    public CommonResponse snsLogin(){
        return CommonResponse.success(null);
    }

    @PostMapping("/account/logout")
    public CommonResponse logout(){
        return CommonResponse.success(null);
    }

    @DeleteMapping("/account")
    public CommonResponse deleteUser(){
        return CommonResponse.success(null);
    }

    @PatchMapping("/account/closed")
    public CommonResponse closeUser(){
        return CommonResponse.success(null);
    }

    @GetMapping("/profile")
    public CommonResponse getProfile(){
        return CommonResponse.success(null);
    }

    @PatchMapping("/profile")
    public CommonResponse updateProfile(){
        return CommonResponse.success(null);
    }

    @GetMapping("/mentoring")
    public CommonResponse getUserMentorings(){
        return CommonResponse.success(null);
    }

    @GetMapping("/mentoring/{mentoringId}")
    public CommonResponse getUserMentoring(){
        return CommonResponse.success(null);
    }

    @GetMapping("/mentoring/{mentoringId}")
    public CommonResponse updateUserMentoring(){
        return CommonResponse.success(null);
    }


}
