package edu.sysu.yuepiao.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by moret on 2017/6/7.
 */

@Embeddable
public class WatchId implements Serializable
{
    public long userId;
    public long roundId;
    @Column(name = "seat_x")
    public long seatX;
    @Column(name = "seat_y")
    public long seatY;
}
