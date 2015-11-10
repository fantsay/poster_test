package net.nixj.poster.services;

import net.nixj.poster.entity.Poster;
import net.nixj.poster.entity.Rubric;
import net.nixj.poster.entity.User;
import net.nixj.poster.repository.PosterRepository;
import net.nixj.poster.repository.RubricRepository;
import net.nixj.poster.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by fantsay on 10/23/15.
 */
@Service
public class PosterService {
    @Autowired
    private UserRepository urepos;
    @Autowired
    private PosterRepository prepos;
    @Autowired
    private RubricRepository rrepos;

    public void createPoster(User author, Rubric rubric, String header, String body)
    {
   if (urepos.isUserPresent(author.getLogin())&&rrepos.isPresent(rubric.getRubricName())) //TODO:nullpointer
   {
    Poster poster = new Poster(author,rubric, header, body);
       prepos.addPoster(poster);

   }



    }
public List<Poster> getPosterByLogin(String login)
{
    return prepos.findByLogin(login);
}
public List<Poster> getAll()
{
    return prepos.findAllPosters();
}

    public List<Poster> getByAuthorName(String name)
    {
        return prepos.findByAuthorName(name);
    }
    public List<Poster> getByRubric(String rubrick)
    {
        return prepos.findByRubrick(rubrick);
    }
    public List<Poster> getByTitle(String title){return prepos.findByTitle(title);}






}
