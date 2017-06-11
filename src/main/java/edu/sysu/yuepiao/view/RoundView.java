package edu.sysu.yuepiao.view;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

/**
 * Created by moret on 2017/6/7.
 */
@JsonSerialize
public class RoundView {
    private long id;
    private long price;
    private String place;
    private String version;
    private Date beginTime;

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

    public RoundView(long id, long price, String place, String version, Date beginTime)
    {
        this.id = id;
        this.price = price;
        this.place = place;
        this.version = version;
        this.beginTime = beginTime;
    }
}
