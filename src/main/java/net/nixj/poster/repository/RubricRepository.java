package net.nixj.poster.repository;

import net.nixj.poster.entity.Poster;
import net.nixj.poster.entity.Rubric;
import net.nixj.poster.utils.HibernateUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Created by fantsay on 10/22/15.
 */
@org.springframework.stereotype.Repository
public class RubricRepository   {
    EntityManager em = HibernateUtils.getEm();


    public boolean isPresent(String ent)
    {
        try {
            em.getReference(Rubric.class, ent);
        }
           catch (EntityNotFoundException ex){
               return false;
           }

         return true;
    }

    public void save(Rubric rubric)
    {
        em.getTransaction().begin();
        em.merge(rubric);
        em.flush();
        em.getTransaction().commit();
    }


   public List<Poster> getAllPostByRubricName(String name)
   {
       Rubric reference = em.getReference(Rubric.class, name);
       return reference.getPosters();

   }


    }

