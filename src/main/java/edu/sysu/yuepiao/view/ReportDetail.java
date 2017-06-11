package edu.sysu.yuepiao.view;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Created by moret on 2017/6/8.
 */
@JsonSerialize
@JsonDeserialize
public class ReportDetail {
    private long seatX;
    private long seatY;

    public ReportDetail() {}

    public ReportDetail(long seatX, long seatY) {
        this.seatX = seatX;
        this.seatY = seatY;
    }

    public long getSeatX() {

        return seatX;
    }

    public void setSeatX(long seatX) {
        this.seatX = seatX;
    }

    public long getSeatY() {
        return seatY;
    }

    public void setSeatY(long seatY) {
        this.seatY = seatY;
    }
}
