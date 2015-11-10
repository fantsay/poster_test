package net.nixj.poster.config;

/**
 * Created by fantsay on 11/1/15.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;


import javax.annotation.PostConstruct;

/**
 * Configuration of the business, persistence and security layers.
 */
@Configuration
@Import(value = {
        WebSecurityConfig.class
} )
public class MainConfig {



    @Autowired
    private Environment         env;

    /**
     * Application custom initialization code.
     * <p/>
     * Spring profiles can be configured with a system property
     * -Dspring.profiles.active=javaee
     * <p/>
     */
    @PostConstruct
    public void initApp() {
        if (env.getActiveProfiles().length == 0) {
        } else {
            for (String profile : env.getActiveProfiles()) {
            }
        }
    }
}
