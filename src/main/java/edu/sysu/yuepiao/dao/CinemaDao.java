package edu.sysu.yuepiao.dao;

import edu.sysu.yuepiao.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

/**
 * Created by moret on 2017/6/6.
 */
@Transactional
public interface CinemaDao extends JpaRepository<Cinema, Long> {
}
