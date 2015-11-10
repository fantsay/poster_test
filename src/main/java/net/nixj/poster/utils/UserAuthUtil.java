package net.nixj.poster.utils;

import net.nixj.poster.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component("userAuthUtil")
public class UserAuthUtil  implements UserDetailsService {

    @Autowired
    UserService service;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        net.nixj.poster.entity.User u = service.findUserByLogin(s);


        return new User(u.getLogin(),u.getPassword(),u.getRole());



    }
}