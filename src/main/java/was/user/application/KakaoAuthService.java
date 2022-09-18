package was.user.application;

import org.springframework.stereotype.Service;
import was.user.interfaces.request.AuthRequest;
import was.user.interfaces.response.AuthResponse;


@Service
public class KakaoAuthService implements AuthService{

    @Override
    public AuthResponse authenticate(AuthRequest authRequest) {
        // todo list
        // 카카오 sns 인증 구현

        return null;
    }

}
