package was.config;

import io.jsonwebtoken.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import was.common.exception.EmptyJwtException;
import was.common.exception.InvalidJwtException;
import was.user.domain.user.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service
public class JwtManager {

    @Value("${jwt.secret}")
    private static String JWT_SECRET_KEY;

    public static String createJwt(User.UserRole userRole, User.LoginType loginType, String id) {
        Date now = new Date();
        return Jwts.builder()
                .setHeaderParam("type", "jwt")
                .claim("id", id)
                .claim("userRole", userRole.name())
                .claim("loginType", loginType.name())
                .setIssuedAt(now)
                .setExpiration(new Date(System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 365)) // TODO. 유효기간 1년(차후 수정)
                .signWith(SignatureAlgorithm.HS256, JWT_SECRET_KEY) // TODO. duplicate method 수정
                .compact();
    }

    public static String getId() {
        //1. JWT 추출
        String jwt = getJwt();

        // 2. JWT parsing
        Jws<Claims> claims = parseToClaims(jwt);

        // 3. id 추출
        Claims claimsBody = claims.getBody();
        try {
            return claimsBody.get("id", String.class);
        } catch (JwtException e) {
            return String.valueOf(claimsBody.get("id", String.class));
        }
    }

    public static String getMemberType() {
        try {
            String token = getJwt();
            validateTokenIsEmpty(token);
            Jws<Claims> claimsJws = parseToClaims(token);
            return claimsJws.getBody().get("userRole", String.class);
        } catch (Exception e) {
            throw new InvalidJwtException();
        }
    }

    private static Jws<Claims> parseToClaims(String accessToken) {
        try {
            return Jwts.parserBuilder() // Jwt가 유효하지 않다면 parseClaimsJws() 에서 JwtException이 발생한다.
                    .setSigningKey(JWT_SECRET_KEY)
                    .build().parseClaimsJws(accessToken);
        } catch (Exception e) {
            throw new InvalidJwtException();
        }
    }
    private static void validateTokenIsEmpty(String accessToken) {
        if (accessToken == null || accessToken.isEmpty()) {
            throw new EmptyJwtException();
        }
    }

    // Header에서 X-ACCESS-TOKEN 으로 JWT 추출
    private static String getJwt() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        return request.getHeader("X-ACCESS-TOKEN");
    }
}
