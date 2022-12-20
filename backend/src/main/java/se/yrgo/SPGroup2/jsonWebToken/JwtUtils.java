package se.yrgo.SPGroup2.jsonWebToken;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.*;
import se.yrgo.SPGroup2.domain.UserDetailsImpl;

/**
 * Utility class used to create and validate JSON Web Tokens.
 */
@Component
public class JwtUtils {
  private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

  @Value("${yrgo.app.jwtSecret}")
  private String jwtSecret;

  @Value("${yrgo.app.jwtExpirationMs}")
  private int jwtExpirationMs;

  /**
   * This method is used to generate a JWT token for a user.
   * @param authentication
   * @return JWT token in the form of a String
   */
  public String generateJwtToken(Authentication authentication) {

    UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

    return Jwts.builder().setSubject((userPrincipal.getUsername())).setIssuedAt(new Date())
        .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs)).signWith(SignatureAlgorithm.HS512, jwtSecret)
        .compact();

  }

  /**
   * This method is used to get the username from a JWT token.
   * @param token
   * @return username
   */
  public String getUserNameFromJwtToken(String token) {
    return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
  }

  /**
   * This method is used to validate a JWT token.
   * Returns true if the token is valid, otherwise false.
   * @param authToken
   * @return boolean
   */
  public boolean validateJwtToken(String authToken) {
    try {
      Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
      return true;
    } catch (SignatureException e) {
      logger.error("Invalid JWT signature: {}", e.getMessage());
    } catch (MalformedJwtException e) {
      logger.error("Invalid JWT token: {}", e.getMessage());
    } catch (ExpiredJwtException e) {
      logger.error("JWT token is expired: {}", e.getMessage());
    } catch (UnsupportedJwtException e) {
      logger.error("JWT token is unsupported: {}", e.getMessage());
    } catch (IllegalArgumentException e) {
      logger.error("JWT claims string is empty: {}", e.getMessage());
    }

    return false;
  }
}
