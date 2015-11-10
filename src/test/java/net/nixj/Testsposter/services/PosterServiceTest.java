package net.nixj.Testsposter.services;

import net.nixj.poster.entity.Rubric;
import net.nixj.poster.entity.User;
import net.nixj.poster.services.PosterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.LocalDate;

/**
 * Created by fantsay on 10/24/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = net.nixj.Testsposter.TesConfig.class)
@WebAppConfiguration
public class PosterServiceTest {

    @Autowired
    PosterService service;
    @Test
    public void testCreatePoster() throws Exception {

    service.createPoster(new User("fantsay", "Sergey", "111"), new Rubric("продажа"), "First Poster", "Hey HEyvvvvvvvvvvvvv vvvvvvvvH");

    }
}