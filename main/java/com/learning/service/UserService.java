package com.learning.service;

import com.learning.model.User;
import com.learning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(String login, String password, String email)
    {
        if(login != null && password != null)
        {
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user.setEmail(email);
            return userRepository.save(user);
        }else {
            return null;
        }
    }

    public User authenticate(String login, String password)
    {
        return userRepository.findByLoginAndPassword(login, password).orElse(null);
    }
}
