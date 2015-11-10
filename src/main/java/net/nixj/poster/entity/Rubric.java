package net.nixj.poster.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

/**
 * Created by fantsay on 10/19/15.
 */
@JsonAutoDetect
@Component
@Entity(name = "rubric")
public class Rubric implements Serializable{
    @Id
    private String rubricName;

    public void setPosters(List<Poster> posters) {
        this.posters = posters;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "rubric",fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private List<Poster> posters;

    public Rubric(){}

    public Rubric(String name) {
        this.rubricName = name;
    }


    public void setRubricName(String name) {
        this.rubricName = name;
    }

    public String getRubricName() {
        return rubricName;
    }


    public List<Poster> getPosters() {return posters;}




}
