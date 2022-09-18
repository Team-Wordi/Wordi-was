package was.user.application;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import was.user.interfaces.request.AuthRequest;
import was.user.interfaces.request.SnsAuthUserInfo;
import was.user.interfaces.response.AuthResponse;

@AllArgsConstructor
@Service
public class GoogleAuthService implements AuthService{

    @Override
    public AuthResponse authenticate(AuthRequest authRequest) {
        // todo list
        // 구글 sns 인증 구현

        return null;
    }
}
