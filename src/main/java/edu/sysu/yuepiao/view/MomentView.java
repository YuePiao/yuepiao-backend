package edu.sysu.yuepiao.view;

import edu.sysu.yuepiao.model.Watch;
import edu.sysu.yuepiao.model.WatchId;

import java.util.Date;

/**
 * Created by moret on 2017/6/7.
 */
public class MomentView {
    private WatchId id;
    private String movie;
    private String cinema;
    private long price;
    private String place;
    private Date beginTime;

    public MomentView(Watch w)
    {
        this.id = w.getId();
        this.movie = w.getRound().getMovie().getName();
        this.cinema = w.getRound().getCinema().getName();
        this.price = w.getRound().getPrice();
        this.place = w.getRound().getPlace();
        this.beginTime = w.getRound().getBeginTime();
    }

    public MomentView(WatchId id, String movie, String cinema, long price, String place, Date beginTime) {
        this.id = id;
        this.movie = movie;
        this.cinema = cinema;
        this.price = price;
        this.place = place;
        this.beginTime = beginTime;
    }

    public WatchId getId() {
        return id;
    }

    public void setId(WatchId id) {
        this.id = id;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getCinema() {
        return cinema;
    }

    public void setCinema(String cinema) {
        this.cinema = cinema;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }
}
