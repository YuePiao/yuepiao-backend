package edu.sysu.yuepiao.view;

import edu.sysu.yuepiao.model.User;

/**
 * Created by moret on 2017/6/9.
 */
public class UserView {
    private long userId;
    private String username;
    private String avatar;

    public UserView(User user) {
        userId = user.getId();
        username = user.getUsername();
        avatar = user.getAvatar();
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public UserView(long userId, String username, String avatar) {

        this.userId = userId;
        this.username = username;
        this.avatar = avatar;
    }
}
