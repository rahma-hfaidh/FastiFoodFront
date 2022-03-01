package com.example.testing;

import android.icu.text.DateFormat;

import java.util.Date;

public class commande {
    public int id_fact;
    public String adresse;
    public int id_client;
    public double somme_fact;
    public String status;
    public String date;
    public String mode_payement;
    public String etat;
    public String heure;

    public commande(int id_fact, String adresse, int id_client, double somme_fact,  String status,String date, String mode_payement,String etat, String heure) {
        this.id_fact = id_fact;
        this.adresse = adresse;
        this.id_client = id_client;
        this.somme_fact = somme_fact;

        this.status = status;
        this.etat=etat;
        this.heure= heure;
        this.date=date;
        this.mode_payement = mode_payement;
    }

    public void setSomme_fact(double somme_fact) {
        this.somme_fact = somme_fact;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId_fact() {
        return id_fact;
    }

    public void setId_fact(int id_com) {
        this.id_fact = id_com;
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

    public double getSomme_fact() {
        return somme_fact;
    }

    public void setSomme_com(double somme_com) {
        this.somme_fact = somme_com;
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
                "id_com=" + id_fact +
                ", adresse='" + adresse + '\'' +
                ", id_client=" + id_client +
                ", somme_com=" + somme_fact +
                ", status='" + status + '\'' +
                ", date='" + date + '\'' +
                ", mode_payement='" + mode_payement + '\'' +
                '}';
    }
}
