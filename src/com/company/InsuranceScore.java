package com.company;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsuranceScore {
    private String firstName;
    private String lastName;
    private int score;
    private String riskLevel;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getScore() {
        return score;
    }
    public String getRiskLevel() {
        return riskLevel;
    }
}
