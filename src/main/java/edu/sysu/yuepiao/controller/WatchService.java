package edu.sysu.yuepiao.controller;

import edu.sysu.yuepiao.dao.WatchDao;
import edu.sysu.yuepiao.model.Watch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by moret on 2017/6/7.
 */
@RestController
public class WatchService {
    @RequestMapping(value = "/api/users/{userId}/rounds", method = RequestMethod.GET)
    public Collection<Watch> getWatch(@PathVariable long userId)
    {
        return watchDao.findById_UserId(userId);
    }

    @Autowired
    private WatchDao watchDao;
}
