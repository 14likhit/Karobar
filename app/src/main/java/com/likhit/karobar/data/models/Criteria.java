package com.likhit.karobar.data.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.HashMap;

public class Criteria implements Serializable {

    @SerializedName("type")
    private String type;

    @SerializedName("text")
    private String text;

    @SerializedName("variable")
    private HashMap<String,VariableDetails> variable;

    public Criteria(String type, String text, HashMap<String,VariableDetails> variable) {
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

    public HashMap<String,VariableDetails> getVariable() {
        return variable;
    }

    public void setVariable(HashMap<String,VariableDetails> variable) {
        this.variable = variable;
    }
}
