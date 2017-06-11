package edu.sysu.yuepiao.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import edu.sysu.yuepiao.dao.UserDao;
import edu.sysu.yuepiao.model.User;
import edu.sysu.yuepiao.view.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/login/{username}", method = RequestMethod.POST)
    public String logIn(@PathVariable String username, String password)
    {
        User user = null;
        try
        {
            user = userDao.findByUsername(username);
        }
        catch (Exception ex)
        {
            return "Error creating the user: " + ex.toString();
        }
        if (user.getPassword().equals(password))
        {
            return "";
        }
        return "";
    }

    @Autowired
    private UserDao userDao;

}