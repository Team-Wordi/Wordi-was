package was.user.interfaces.request;

public interface AuthRequest {
    default <T> T toGenericAuthRequest(Class<T> t) {
        return t.cast(this);
    }
}
