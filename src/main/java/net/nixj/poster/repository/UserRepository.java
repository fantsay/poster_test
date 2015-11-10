package net.nixj.poster.repository;

import net.nixj.poster.entity.User;
import net.nixj.poster.utils.HibernateUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

/**
 * Created by fantsay on 10/22/15.
 */
@Repository
public class UserRepository {
    EntityManager em = HibernateUtils.getEm();



    public <T extends User> void save(T ent) {


        {
            em.getTransaction().begin();
            em.merge(ent);
            em.flush();
            em.getTransaction().commit();
        }


    }


    public <T extends User> void delete(T ent) {
        if (this.isUserPresent(ent.getLogin()))
            em.remove(ent);

    }


    public User findByLogin(String login)
    {
        return em.find(User.class,login);
    }

    public boolean isUserPresent(String login)
    {

    return em.find(User.class,login)!=null ;
    }
}
