package com.example.testing.Models;

public class Restaurant {
    public int id_restau;
    public String designation;
    public String logo;

    public Restaurant(int id_restau, String designation, String logo) {
        this.id_restau = id_restau;
        this.designation = designation;
        this.logo = logo;
    }

    public Restaurant() {
    }

    public int getId_restau() {
        return id_restau;
    }

    public void setId_restau(int id_restau) {
        this.id_restau = id_restau;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id_restau=" + id_restau +
                ", designation='" + designation + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }
}
