package edu.sysu.yuepiao.view;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import edu.sysu.yuepiao.model.Round;

import java.util.Date;

/**
 * Created by moret on 2017/6/7.
 */
@JsonSerialize
public class RoundView {
    private long id;
    private long movieId;
    private long cinemaId;

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public long getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(long cinemaId) {
        this.cinemaId = cinemaId;
    }

    private long price;
    private String place;
    private String version;
    private Date beginTime;
    private long rows;
    private long columns;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public RoundView(Round round)
    {
        this.id = round.getId();
        this.price = round.getPrice();
        this.place = round.getPlace();
        this.version = round.getVersion();
        this.beginTime = round.getBeginTime();
        this.rows = round.getRows();
        this.columns = round.getColumns();
        this.movieId = round.getMovie().getId();
        this.cinemaId = round.getCinema().getId();
    }

    public long getRows() {
        return rows;
    }

    public void setRows(long rows) {
        this.rows = rows;
    }

    public long getColumns() {
        return columns;
    }

    public void setColumns(long columns) {
        this.columns = columns;
    }
}
