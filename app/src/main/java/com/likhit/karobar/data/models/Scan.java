package com.likhit.karobar.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Scan {

    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;

    @SerializedName("tag")
    private String tag;

    @SerializedName("color")
    private String color;

    @SerializedName("criteria")
    private List<Criteria> crieteria;

    public Scan(Integer id, String name, String tag, String color, List<Criteria> crieteria) {
        this.id = id;
        this.name = name;
        this.tag = tag;
        this.color = color;
        this.crieteria = crieteria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Criteria> getCrieteria() {
        return crieteria;
    }

    public void setCrieteria(List<Criteria> crieteria) {
        this.crieteria = crieteria;
    }

    @Override
    public String toString() {
        return "Scan{" +
                "name=" + name +
                ",tag=" + tag +
                "}";
    }
}
