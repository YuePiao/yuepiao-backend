package edu.sysu.yuepiao.view;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import edu.sysu.yuepiao.model.Movie;

/**
 * Created by moret on 2017/6/6.
 */
@JsonSerialize
public class MovieView {
    private long id;
    private String name;
    private String uri;
    private long rating;
    private String type;

    public MovieView(Movie m)
    {
        this.id = m.getId();
        this.name = m.getName();
        this.uri = m.getUri();
        this.rating = m.getRating();
        this.type = m.getType();
    }

    public MovieView(long id, String name, String uri, long rating, String type)
    {
        this.id = id;
        this.name = name;
        this.uri = uri;
        this.rating = rating;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }
}
