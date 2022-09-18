package was.user.application;

import was.user.interfaces.request.AuthRequest;
import was.user.interfaces.response.AuthResponse;


public interface AuthService {
    AuthResponse authenticate(AuthRequest authRequest);
}
