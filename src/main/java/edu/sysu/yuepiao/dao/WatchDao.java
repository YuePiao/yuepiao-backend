package edu.sysu.yuepiao.dao;

import edu.sysu.yuepiao.model.Watch;
import edu.sysu.yuepiao.model.WatchId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by moret on 2017/6/7.
 */
public interface WatchDao extends JpaRepository<Watch, WatchId> {
    List<Watch> findById_UserId(long userId);
    List<Watch> findById_RoundId(long roundId);
    List<Watch> findById_RoundIdAndId_SeatXAndId_SeatY(long roundId, long seatX, long seatY);
}
