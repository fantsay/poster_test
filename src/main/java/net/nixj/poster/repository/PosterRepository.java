package net.nixj.poster.repository;

import javafx.geometry.Pos;
import net.nixj.poster.entity.Poster;
import net.nixj.poster.utils.HibernateUtils;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by fantsay on 10/22/15.
 */
@org.springframework.stereotype.Repository
public class PosterRepository {
    EntityManager em = HibernateUtils.getEm();
    public void addPoster(Poster poster)
    {
    em.getTransaction().begin();
        em.merge(poster);
        em.flush();
        em.getTransaction().commit();

    }

    public void deletePoster(Poster poster)
    {
        em.getTransaction().begin();
        em.remove(poster);
        em.flush();
        em.getTransaction().commit();

    }

    public List<Poster> findByLogin(String login)
    {


        em.getTransaction().begin();
        List<Poster> posters = em.createQuery("select p from poster p where p.author.login=:login").setParameter("login", login).getResultList();
        em.getTransaction().commit();
        return posters;

    }

    public List<Poster> findByAuthorName(String name)
    {

        char[] chars = name.toCharArray();
        StringBuilder partialname = new StringBuilder();
        partialname.append("%").append(chars[0]).append(chars[1]).append(chars[3]).append("%");
        System.out.println(partialname);
        em.getTransaction().begin();
        List<Poster> posters = em.createQuery("select p from poster p where p.author.name like :name").setParameter("name", partialname).getResultList();
        em.getTransaction().commit();
        return posters;
    }

    public List<Poster> findAllPosters()
    {
        List<Poster> posters = em.createQuery("select p from poster p").getResultList();
        return posters;
    }

    public List<Poster> findByRubrick(String rubrick)
    {
        em.getTransaction().begin();
        List<Poster> posters = em.createQuery("select p from poster p where p.rubric.rubricName=:rubrick").setParameter("rubrick", rubrick).getResultList();
        em.getTransaction().commit();
        return posters;
    }

    public List<Poster> findByTitle(String header)
    {
        String exp = "%"+header+"%";
        em.getTransaction().begin();
        List<Poster> posters = em.createQuery("select p from poster p where p.header like :header").setParameter("header", header).getResultList();
        em.getTransaction().commit();
        return posters;
    }

}
