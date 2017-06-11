package edu.sysu.yuepiao.controller;

import edu.sysu.yuepiao.dao.RoundDao;
import edu.sysu.yuepiao.dao.UserDao;
import edu.sysu.yuepiao.dao.WatchDao;
import edu.sysu.yuepiao.model.Round;
import edu.sysu.yuepiao.model.User;
import edu.sysu.yuepiao.model.Watch;
import edu.sysu.yuepiao.view.ReportDetail;
import edu.sysu.yuepiao.view.SeatView;
import edu.sysu.yuepiao.view.RoundView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by moret on 2017/6/7.
 */
@RestController
public class RoundService {
    @RequestMapping(value = "/api/movies/{movieId}/cinemas/{cinemaId}/rounds", method = RequestMethod.GET)
    public Collection<RoundView> getRounds(@PathVariable Long movieId, @PathVariable Long cinemaId)
    {
        return roundDao.findByMovie_IdAndCinema_Id(movieId, cinemaId).stream()
                .map(r -> new RoundView(r.getId(), r.getPrice(), r.getPlace(), r.getVersion(), r.getBeginTime()))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/api/rounds/{roundId}", method = RequestMethod.GET)
    public Collection<SeatView> getRoundDetail(@PathVariable Long roundId)
    {
        return watchDao.findById_RoundId(roundId).stream()
                .map(w -> new SeatView(w.getId(), w.getUser().getReportedCount()))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/api/rounds/{roundId}/report", method = RequestMethod.POST)
    @Transactional
    public void postReport(@PathVariable Long roundId, @RequestBody ReportDetail[] reportDetails)
    {
        Arrays.stream(reportDetails).map(r ->
            watchDao.findById_RoundIdAndId_SeatXAndId_SeatY(roundId, r.getSeatX(), r.getSeatY()).stream().map(w ->
                w.getUser().getId()
            ).collect(Collectors.toList())
        ).flatMap(List::stream).forEach(id -> {
            User user = userDao.findOne(id);
            user.incReportedCount();
            userDao.save(user);
        });
    }

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoundDao roundDao;

    @Autowired
    private WatchDao watchDao;
}
