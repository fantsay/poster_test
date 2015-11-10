package net.nixj.poster.entity;



import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;


/**
 * Created by fantsay on 10/19/15.
 */
@JsonAutoDetect
@Component
@Entity (name = "poster")
public class Poster implements Serializable{
    public Poster()
    {
        this.created_date = Instant.now().getEpochSecond();
    }

    @NotNull(message = "Name must be selected")

    @ManyToOne

    private User author;

    private long created_date;

    public User getAuthor() {
        return author;
    }

    public long getId() {
        return id;
    }

    @ManyToOne
    private Rubric rubric;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "Header cant be empty")
    @Size(min = 10, max = 30)
    private String header;
    @NotNull(message = "Body cant be empty")
    @Size(min = 20, max = 400)
    private String body;

    public Poster(User author, Rubric rubric, String header, String body) {
        this.author = author;
        this.created_date = Instant.now().getEpochSecond();
        this.rubric = rubric;
        this.header = header;
        this.body = body;
    }
    @JsonIgnore
    public String getAuthorName() {
        return author.getName();
    }

    public long getCreated_date() {
        return created_date;
    }

    public Rubric getRubric() {
        return rubric;
    }

    public void setRubric(Rubric rubric) {
        this.rubric = rubric;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    @JsonIgnore
    @Override
    public String toString() {
        return getAuthorName()+getHeader()+getBody()+getRubric().getRubricName(); // TODO Rewrite StringBuilder
        //TODO equals and HashCode
    }
}

