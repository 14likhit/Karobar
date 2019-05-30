package com.likhit.karobar.data.models;

import java.util.List;
import java.util.Map;

public class Variable {

    private Map<String, List<VariableDetails>> variables;

    public Variable(Map<String, List<VariableDetails>> variables) {
        this.variables = variables;
    }

    public Map<String, List<VariableDetails>> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, List<VariableDetails>> variables) {
        this.variables = variables;
    }
}
