package edu.sysu.yuepiao.controller;

import edu.sysu.yuepiao.dao.CinemaDao;
import edu.sysu.yuepiao.model.Cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by moret on 2017/6/6.
 */
@RestController
public class CinemaService {
    @RequestMapping(value = "/api/movies/{movieId}/cinemas", method = RequestMethod.GET)
    public Collection<Cinema> getCinemas()
    {
        return cinemaDao.findAll();
    }
    @RequestMapping(value = "/api/movies/{movieId}/cinemas/{cinemaId}", method = RequestMethod.GET)
    public Cinema getCinema(@PathVariable Long cinemaId) { return cinemaDao.findOne(cinemaId); }

    @Autowired
    private CinemaDao cinemaDao;
}
