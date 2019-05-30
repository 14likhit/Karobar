package com.likhit.karobar.data.models;

import com.google.gson.annotations.SerializedName;

public class Criteria {

    @SerializedName("type")
    private String type;

    @SerializedName("text")
    private String text;

    @SerializedName("variable")
    private Variable variable;

    public Criteria(String type, String text, Variable variable) {
        this.type = type;
        this.text = text;
        this.variable = variable;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }
}
