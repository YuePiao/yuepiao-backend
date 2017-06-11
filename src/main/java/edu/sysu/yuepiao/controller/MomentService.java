package edu.sysu.yuepiao.controller;

import edu.sysu.yuepiao.dao.UserDao;
import edu.sysu.yuepiao.dao.WatchDao;
import edu.sysu.yuepiao.model.User;
import edu.sysu.yuepiao.model.Watch;
import edu.sysu.yuepiao.view.MomentView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by moret on 2017/6/7.
 */
@RestController
public class MomentService {

    private List<MomentView> getViewList(long userId)
    {
        return watchDao.findById_UserId(userId).stream()
                .map(u -> new MomentView(u.getId(),
                        u.getRound().getMovie().getName(),
                        u.getRound().getCinema().getName(),
                        u.getRound().getPrice(),
                        u.getRound().getPlace(),
                        u.getRound().getBeginTime()))
                .sorted((o1, o2) -> o1.getBeginTime().compareTo(o2.getBeginTime()))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/api/users/{userId}/moments", method = RequestMethod.GET)
    public Collection<MomentView> getMoments(@PathVariable long userId)
    {
        return getViewList(userId);
    }

    @RequestMapping(value = "/api/users/{userId}/following/moments", method = RequestMethod.GET)
    public Collection<MomentView> getFollowingMoments(@PathVariable long userId)
    {
        return userDao.findOne(userId).getFollowing().stream()
                .map(User::getId)
                .map(this::getViewList)
                .flatMap(List::stream)
                .sorted((o1, o2) -> o1.getBeginTime().compareTo(o2.getBeginTime()))
                .collect(Collectors.toList());
    }

    @Autowired
    private WatchDao watchDao;

    @Autowired
    private UserDao userDao;
}
