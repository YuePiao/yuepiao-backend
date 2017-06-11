package edu.sysu.yuepiao.view;

/**
 * Created by moret on 2017/6/11.
 */
public class FollowerPost {
    private long to_id;

    FollowerPost() {}

    public FollowerPost(long to_id) {
        this.to_id = to_id;
    }

    public long getTo_id() {
        return to_id;
    }

    public void setTo_id(long to_id) {
        this.to_id = to_id;
    }
}
