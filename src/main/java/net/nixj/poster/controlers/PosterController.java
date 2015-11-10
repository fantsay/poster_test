package net.nixj.poster.controlers;

import net.nixj.poster.entity.Poster;
import net.nixj.poster.services.PosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by fantsay on 11/8/15.
 */
@RestController
public class PosterController {
    @Autowired
    PosterService service;

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public List<Poster> posterSearch(@RequestBody List<String> body, HttpServletRequest request,
                                     HttpServletResponse response, Model model)
    {
        String rubrick = body.get(0); // TODO:  Убрать условия, передвать параметры в запрос скуля. Для реализации поиска по нескольким критериям
        String poster = body.get(1);
        String author = body.get(2);
        String mine = body.get(3);
//        if (mine.equals("true"))
//        {
//            System.out.printf("mine");
//            return service.getPosterByLogin(request.getUserPrincipal().getName());
//        }
        if (poster!=null)
        {
            System.out.printf("title" +  poster);
            return service.getByTitle(poster);
        }

        if (author!=null)
        {
            return service.getByAuthorName(author);
        }

        if (rubrick!=null){return service.getByRubric(rubrick);}



        return null;
    }

    @RequestMapping(value = "/poster", method = RequestMethod.GET)
    public
    List<Poster> getPoster() {
        return service.getAll();
    }
}

