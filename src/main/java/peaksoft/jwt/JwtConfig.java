package peaksoft.jwt;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.http.HttpHeaders;


@Getter
@Setter
@ConfigurationProperties(prefix = "application.jwt")
@Component
public class JwtConfig {
//    @Value("${application.jwt.secretKey}")
    private String secretKey;

//    @Value("${application.jwt.secretKey}")
    private String tokenPrefix;

//    @Value("${application.jwt.secretKey}")
    private Long expirationDateAfterDays;

    public String getAuthorizationHeader() {
        return HttpHeaders.AUTHORIZATION;
    }
}
