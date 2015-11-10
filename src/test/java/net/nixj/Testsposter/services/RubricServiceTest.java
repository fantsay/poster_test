package net.nixj.Testsposter.services;

import net.nixj.poster.services.RubricService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by fantsay on 10/24/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = net.nixj.Testsposter.TesConfig.class)
@WebAppConfiguration
public class RubricServiceTest {


    @Autowired
    RubricService service;

    @Test
    public void testCreateRubric() throws Exception {
    service.createRubric("прочее");
    service.createRubric("продажа");
        service.createRubric("покупка");
        service.createRubric("аренда");
        service.createRubric("услуги");
        service.createRubric("знакомства");


    }
}