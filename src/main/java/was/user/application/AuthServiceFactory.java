package was.user.application;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import was.user.domain.user.exception.AuthTypeException;
import was.user.interfaces.request.AuthRequest;
import was.user.interfaces.response.AuthResponse;

@Slf4j
@AllArgsConstructor
public class AuthServiceFactory {

    AuthService authService;

    // 생성자에 주입된 Service 구현체에 맞는 로그인 서비스 구현
    public AuthResponse authenticate(AuthRequest authRequest) {
        if (authService == null) throw new AuthTypeException();
        return authService.authenticate(authRequest);
    }


// 차후 Factory 생성자에 로그인 타입에 따른 객체를 매개변수로 넣어주기 위한 로직
//    public static AuthService get(LoginType loginType) {
//        switch (loginType) {
//            case KAKAO: return new KakaoAuthService();
//            case GOOGLE: return new GoogleAuthService();
//            case APPLE: return new AppleAuthService();
//            default: throw new AuthTypeException();
//        }
//    }

}
