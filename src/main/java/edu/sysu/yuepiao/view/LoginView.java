package edu.sysu.yuepiao.view;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import edu.sysu.yuepiao.model.User;

import java.security.MessageDigest;


/**
 * Created by moret on 2017/6/11.
 */
@JsonSerialize
public class LoginView {
    private UserView userView;
    private String digest;

    public LoginView() {}

    public LoginView(UserView userView, String digest) {
        this.userView = userView;
        this.digest = digest;
    }

    public UserView getUserView() {

        return userView;
    }

    public void setUserView(UserView userView) {
        this.userView = userView;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }
}
