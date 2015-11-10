package net.nixj.Testsposter.utils;

import net.nixj.poster.entity.Rubric;
import net.nixj.poster.services.PosterService;
import net.nixj.poster.services.RubricService;
import net.nixj.poster.services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.LocalDate;

/**
 * Created by fantsay on 11/8/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = net.nixj.Testsposter.TesConfig.class)
@WebAppConfiguration
public class PopulateDB {
    @Autowired
    RubricService rubricService;
    @Autowired
    UserService userService;
    @Autowired
    PosterService posterService;

    @Test
    public void populate()

    {

        userService.createUser("admin", "Sergey", "111");
        userService.createUser("root", "Антуан", "admin");
        userService.createUser("alexander", "Петрушка", "admin");
        userService.createUser("Dima", "Dimitriy", "admin");

        rubricService.createRubric("прочее");
        rubricService.createRubric("продажа");
        rubricService.createRubric("покупка");
        rubricService.createRubric("аренда");
        rubricService.createRubric("услуги");
        rubricService.createRubric("знакомства");



        for (int i = 0; i<=20;i++){
        posterService.createPoster(userService.findUserByLogin("admin"),new Rubric("знакомства"),"Название обьявления","В этом месте можно долго и нудно писать? Состояние 4 из 5. Две сим карты. Связь отличная, разговорный динамик хорош. Характеристика см. в интернете. Полный комплект (кроме гарнитуры).");
       }
        for (int i = 0; i<=20;i++){
            posterService.createPoster(userService.findUserByLogin("root"),new Rubric("прочее"),"Телефон продам" ,"В этом месте можно долго и нудно писать? Состояние 4 из 5. Две сим карты. Связь отличная, разговорный динамик хорош. Характеристика см. в интернете. Полный комплект (кроме гарнитуры).");
        }
        for (int i = 0; i<=20;i++){
            posterService.createPoster(userService.findUserByLogin("alexander"),new Rubric("продажа"),"Продам что нибуть","В этом месте можно долго и нудно писать? Состояние 4 из 5. Две сим карты. Связь отличная, разговорный динамик хорош. Характеристика см. в интернете. Полный комплект (кроме гарнитуры).");
        }
        for (int i = 0; i<=20;i++){
            posterService.createPoster(userService.findUserByLogin("Dima"),new Rubric("прочее"),"Название обьявления","В этом месте можно долго и нудно писать? Состояние 4 из 5. Две сим карты. Связь отличная, разговорный динамик хорош. Характеристика см. в интернете. Полный комплект (кроме гарнитуры).");
        }
        Assert.assertTrue(true);
    }



}
