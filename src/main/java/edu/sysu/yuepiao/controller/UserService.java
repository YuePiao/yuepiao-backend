package edu.sysu.yuepiao.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import edu.sysu.yuepiao.dao.UserDao;
import edu.sysu.yuepiao.model.User;
import edu.sysu.yuepiao.view.AccountView;
import edu.sysu.yuepiao.view.LoginView;
import edu.sysu.yuepiao.view.UserView;
import org.apache.tomcat.util.codec.binary.Base64;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by moret on 2017/6/5.
 */
@RestController
public class UserService {

    @RequestMapping(value = "/api/users/{userId}/followers", method = RequestMethod.GET)
    public Collection<Long> getFollowers(@PathVariable long userId)
    {
        return userDao.findOne(userId).getFollowers().stream().map(User::getId).collect(Collectors.toList());
    }

    @RequestMapping(value = "/api/users/{userId}/following", method = RequestMethod.GET)
    public Collection<Long> getFollowing(@PathVariable long userId)
    {
        return userDao.findOne(userId).getFollowing().stream().map(User::getId).collect(Collectors.toList());
    }

    @RequestMapping(value = "/api/users/{userId}", method = RequestMethod.GET)
    public UserView getUserView(@PathVariable long userId)
    {
        return new UserView(userDao.findOne(userId));
    }

    @RequestMapping("/signup")
    public String signUp(String username, String password)
    {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        try
        {
            userDao.save(user);
        }
        catch (Exception ex)
        {
            return "Error creating the user: " + ex.toString();
        }
        return String.valueOf(user.getId());
    }

    @RequestMapping(value = "/api/login/", method = RequestMethod.POST)
    public LoginView logIn(@RequestBody AccountView input) {
        User user = null;
        user = userDao.findByUsername(input.getUsername());
        if (!user.getPassword().equals(input.getPassword()))
        {
            return new LoginView();
        }

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
            String digest = Base64.encodeBase64String(md.digest((String.valueOf(user.getId()) + String.valueOf(System.currentTimeMillis())).getBytes()));
            user.setDigest(digest);
            userDao.save(user);
            return new LoginView(new UserView(user), digest);
        } catch (NoSuchAlgorithmException ex) {

        }
        return new LoginView();
    }

    @Autowired
    private UserDao userDao;

}