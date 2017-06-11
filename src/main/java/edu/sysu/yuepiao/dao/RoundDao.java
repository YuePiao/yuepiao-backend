package edu.sysu.yuepiao.dao;

import edu.sysu.yuepiao.model.Round;
import edu.sysu.yuepiao.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by moret on 2017/6/6.
 */
public interface RoundDao extends JpaRepository<Round, Long> {
    List<Round> findByMovie_IdAndCinema_Id(long movieId, long cinemaId);
}
