package edu.sysu.yuepiao.view;

import edu.sysu.yuepiao.model.Round;
import edu.sysu.yuepiao.model.User;
import edu.sysu.yuepiao.model.WatchId;

import java.util.List;

/**
 * Created by moret on 2017/6/8.
 */
public class SeatView {
    private WatchId id;
    private long reportedCount;

    public SeatView(WatchId id, long reportedCount) {
        this.id = id;
        this.reportedCount = reportedCount;
    }

    public WatchId getId() {

        return id;
    }

    public void setId(WatchId id) {
        this.id = id;
    }

    public long getReportedCount() {
        return reportedCount;
    }

    public void setReportedCount(long reportedCount) {
        this.reportedCount = reportedCount;
    }
}
