package net.nixj.Testsposter.services;

import net.nixj.poster.entity.User;
import net.nixj.poster.repository.UserRepository;
import net.nixj.poster.services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by fantsay on 10/23/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = net.nixj.Testsposter.TesConfig.class)
@WebAppConfiguration
public class UserServiceTest {

    @Autowired
    private UserService service;
    @Autowired
    UserRepository repository;
    @Test
    public void testCreateUser() throws Exception {
        service.createUser("admin","Sergey","111");
        service.createUser("root","Антуан","admin");
        service.createUser("alexander","Петрушка","admin");
        service.createUser("Dima","Dimitriy","admin");



    }
    @Test
    public void testFindUserByLogin() throws Exception {

        User fantsay = service.findUserByLogin("admin");
        Assert.assertFalse(fantsay==null);
    }
        @Test
    public void testUserPresent() throws Exception
        {
            Assert.assertTrue(repository.isUserPresent("fantsay"));
        }

}