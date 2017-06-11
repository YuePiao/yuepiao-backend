package edu.sysu.yuepiao.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "watches")
public class Watch {
    public WatchId getId() {
        return id;
    }

    public void setId(WatchId id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    @EmbeddedId
    private WatchId id;

    @MapsId("userId")
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User user;

    @MapsId("roundId")
    @JoinColumn(name = "round_id", referencedColumnName = "id")
    @ManyToOne
    private Round round;

}
