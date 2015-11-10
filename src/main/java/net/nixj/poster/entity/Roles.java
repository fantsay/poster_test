package net.nixj.poster.entity;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.security.core.GrantedAuthority;

/**
 * Created by fantsay on 10/22/15.
 */
@JsonIgnoreProperties
public enum Roles implements GrantedAuthority{ ROLE_ADMIN ,ROLE_USER;
    @Override
    public String getAuthority() {
        return name();
    }
}

