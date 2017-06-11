package edu.sysu.yuepiao.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by moret on 2017/6/5.
 */

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private long reportedCount;

    private String avatar;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @ManyToMany
    @JoinTable(name = "user_rels", joinColumns = {@JoinColumn(name = "to_id")}, inverseJoinColumns = {@JoinColumn(name = "from_id")})
    @JsonIgnore
    private Set<User> followers = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "user_rels", joinColumns = {@JoinColumn(name = "from_id")}, inverseJoinColumns = {@JoinColumn(name = "to_id")})
    @JsonIgnore
    private Set<User> following = new HashSet<>();

    public Set<User> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<User> followers) {
        this.followers = followers;
    }

    public Set<User> getFollowing() {
        return following;
    }

    public void setFollowing(Set<User> following) {
        this.following = following;
    }

    public long getId() {
        return id;
    }

    public void setId(long value) {
        this.id = value;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String value) {
        this.username = value;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String value) {
        this.password = value;
    }

    public void setReportedCount(long value) {
        this.reportedCount = value;
    }

    public long getReportedCount() {
        return this.reportedCount;
    }

    public void incReportedCount() { this.reportedCount += 1; }

} // class User