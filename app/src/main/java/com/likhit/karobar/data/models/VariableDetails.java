package com.likhit.karobar.data.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VariableDetails implements Serializable {

    @SerializedName("type")
    private String type;

    @SerializedName("study_type")
    private String studyType;

    @SerializedName("parameter_name")
    private String parameterName;

    @SerializedName("min_value")
    private Integer minValue;

    @SerializedName("max_value")
    private Integer maxValue;

    @SerializedName("default_value")
    private Integer defaultValue;

    @SerializedName("values")
    private ArrayList<Float> values;

    public VariableDetails(String type, ArrayList<Float> values) {
        this.type = type;
        this.values = values;
    }

    public VariableDetails(String type, String studyType, String parameterName, Integer minValue, Integer maxValue, Integer defaultValue) {
        this.type = type;
        this.studyType = studyType;
        this.parameterName = parameterName;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.defaultValue = defaultValue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Float> getValues() {
        return values;
    }

    public void setValues(ArrayList<Float> values) {
        this.values = values;
    }

    public String getStudyType() {
        return studyType;
    }

    public void setStudyType(String studyType) {
        this.studyType = studyType;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public Integer getMinValue() {
        return minValue;
    }

    public void setMinValue(Integer minValue) {
        this.minValue = minValue;
    }

    public Integer getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
    }

    public Integer getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Integer defaultValue) {
        this.defaultValue = defaultValue;
    }
}
