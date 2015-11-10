package net.nixj.poster.services;

import net.nixj.poster.entity.User;
import net.nixj.poster.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by fantsay on 10/22/15.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    public void createUser (String login, String name, String password)
    {
    User user = new User(login,name,new BCryptPasswordEncoder().encode(password));
        if (!repository.isUserPresent(login))
        {repository.save(user);}






    }
    public void deleteUser(String login)
    {
        User user = repository.findByLogin(login);// TODO Null pointer
        repository.delete(user);
    }

    public User findUserByLogin(String login) // TODO Repeated function present in repository
        {
            return repository.findByLogin(login);
        }
}
