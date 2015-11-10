package net.nixj.poster.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by fantsay on 10/19/15.
 */
@JsonAutoDetect
@Component
@Entity(name = "suser")
public class User implements Serializable {
    @JsonIgnore
    private final Roles DEFAULT_ROLE = Roles.ROLE_USER;

    public String getLogin() {
        return login;
    }
    @JsonIgnore
    @NotNull
    @Size(min=4, max = 15)
    @Id
    private String login;

    @NotNull
    private String name;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @JsonIgnore
    @NotNull
    private String password;
    @JsonIgnore
    @ElementCollection
    @Enumerated
    private Set<Roles> roles = new HashSet<>();
@JsonIgnore
    public Roles getDEFAULT_ROLE() {
        return DEFAULT_ROLE;
    }

@JsonIgnore
    public List<Poster> getPosters() {
        return posters;
    }

    public void addPoster(Poster poster) {
        this.posters.add(poster);
    }

    @OneToMany(mappedBy = "author")
    @Cascade(value = CascadeType.ALL)
    private List<Poster> posters;// TODO Null pointer

    public User() {
    roles.add(DEFAULT_ROLE);
    }

    public User(String login, String name, String password) {
        this.login = login;
        this.name = name;
        this.password = password;
    }
@JsonIgnore
    public Set<Roles> getRole() {
        return roles;
    }

    public void setRole(Roles role) {
        this.roles.add(role);
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        return this.login == other.login;

    }
}
