package edu.sysu.yuepiao.controller;

import edu.sysu.yuepiao.dao.MovieDao;
import edu.sysu.yuepiao.model.Movie;
import edu.sysu.yuepiao.view.MovieView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by moret on 2017/6/6.
 */
@RestController
public class MoviesService {

    @RequestMapping(value = "/api/movies", method = RequestMethod.GET)
    public Collection<MovieView> getMovies()
    {
        return movieDao.findAll().stream()
                .map(m -> new MovieView(m.getId(), m.getName(), m.getUri(), m.getRating(), m.getType()))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/api/movies/{movieId}", method = RequestMethod.GET)
    public Movie getMovieDetail(@PathVariable long movieId)
    {
        return movieDao.findOne(movieId);
    }

    @Autowired
    private MovieDao movieDao;
}
