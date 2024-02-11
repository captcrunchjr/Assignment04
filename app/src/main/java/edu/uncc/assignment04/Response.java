package edu.uncc.assignment04;

import java.io.Serializable;

public class Response implements Serializable {
    private String name;
    private String email;
    private String role;
    private String educationLevel = "";
    private String maritalStatus = "";
    private String livingStatus = "";
    private String income = "";

    public Response(String name, String email, String role) {
        this.name = name;
        this.email = email;
        this.role = role;
    }

    @Override
    public String toString() {
        return "Response{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", educationLevel='" + educationLevel + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", livingStatus='" + livingStatus + '\'' +
                ", income='" + income + '\'' +
                '}';
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getLivingStatus() {
        return livingStatus;
    }

    public void setLivingStatus(String livingStatus) {
        this.livingStatus = livingStatus;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }
}
