package com.company;
import java.io.Serializable;
public class InsuranceMember implements Serializable{

    private String firstName;
    private String lastName;
    private int age;
    private int height;
    private int weight;
    private int BPSys;
    private int BPDias;
    private String cancer;
    private String diabetes;
    private String alzheimers;

    public void setFirstName(String firstName) {
        this.firstName = firstName.trim();
    }
    public void setLastName(String lastName) {
        this.lastName = lastName.trim();
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public void setBPSys(int BPSys) {
        this.BPSys = BPSys;
    }
    public void setBPDias(int BPDias) {
        this.BPDias = BPDias;
    }
    public void setCancer(String cancer) {
        this.cancer = cancer.trim();
    }
    public void setDiabetes(String diabetes) {
        this.diabetes = diabetes.trim();
    }
    public void setAlzheimers(String alzheimers) {
        this.alzheimers = alzheimers.trim();
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }
    public int getHeight() {
        return height;
    }
    public int getWeight() {
        return weight;
    }
    public int getBPSys() {
        return BPSys;
    }
    public int getBPDias() {
        return BPDias;
    }
    public String getCancer() {
        return cancer;
    }
    public String getDiabetes() {
        return diabetes;
    }
    public String getAlzheimers() {
        return alzheimers;
    }
}
