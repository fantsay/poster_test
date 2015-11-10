
package net.nixj.poster.controlers;

import net.nixj.poster.entity.Poster;
import net.nixj.poster.services.PosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by fantsay on 10/29/15.
 */
@Controller
public class FrontController {

    @Autowired
    PosterService service;

    @RequestMapping(value = "/index")
    public String getIndex() {
        return "index";
    }


    @RequestMapping(value = "/login")
    public String login() {

        return "login";
    }


    @RequestMapping(value = "/")
    public String getRoot() {
        return "index";
    }
}