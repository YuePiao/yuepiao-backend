package edu.sysu.yuepiao.dao;

import edu.sysu.yuepiao.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

/**
 * Created by moret on 2017/6/6.
 */
@Transactional
public interface MovieDao extends JpaRepository<Movie, Long> {

}
