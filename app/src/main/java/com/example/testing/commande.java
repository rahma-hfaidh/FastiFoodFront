package com.example.testing;

import java.util.Date;

public class commande {
    public int id_com;
    public String adresse;


    public int id_client;
    public double somme_com;
    public String reponse;
    public String status;
    public String date;
    public String mode_payement;


    public commande(int id_com, String adresse, int id_client, double somme_com, String reponse, String status,String date, String mode_payement) {
        this.id_com = id_com;
        this.adresse = adresse;
        this.id_client = id_client;
        this.somme_com = somme_com;
        this.reponse = reponse;
        this.status = status;
        this.date=date;
        this.mode_payement = mode_payement;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId_com() {
        return id_com;
    }

    public void setId_com(int id_com) {
        this.id_com = id_com;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public double getSomme_com() {
        return somme_com;
    }

    public void setSomme_com(double somme_com) {
        this.somme_com = somme_com;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMode_payement() {
        return mode_payement;
    }

    public void setMode_payement(String mode_payement) {
        this.mode_payement = mode_payement;
    }

    @Override
    public String toString() {
        return "commande{" +
                "id_com=" + id_com +
                ", adresse='" + adresse + '\'' +
                ", id_client=" + id_client +
                ", somme_com=" + somme_com +
                ", reponse='" + reponse + '\'' +
                ", status='" + status + '\'' +
                ", date='" + date + '\'' +
                ", mode_payement='" + mode_payement + '\'' +
                '}';
    }
}
