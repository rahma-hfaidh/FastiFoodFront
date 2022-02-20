package com.example.testing;


public class Dfacteur {

    public int id_com;
    public String nomRestau;
    public  String reponse;
    public double  somme_Dfacteur;
    int logo;
    public  int id_fact;

    public Dfacteur(int id_com, String nomRestau, String reponse, double somme_Dfacteur, int logo, int id_fact) {
        this.id_com = id_com;
        this.nomRestau = nomRestau;
        this.reponse = reponse;
        this.somme_Dfacteur = somme_Dfacteur;
        this.logo = logo;
        this.id_fact = id_fact;
    }

    public int getId_com() {
        return id_com;
    }

    public void setId_com(int id_com) {
        this.id_com = id_com;
    }

    public String getNomRestau() {
        return nomRestau;
    }

    public void setNomRestau(String nomRestau) {
        this.nomRestau = nomRestau;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public double getSomme_Dfacteur() {
        return somme_Dfacteur;
    }

    public void setSomme_Dfacteur(double somme_Dfacteur) {
        this.somme_Dfacteur = somme_Dfacteur;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public int getId_fact() {
        return id_fact;
    }

    public void setId_fact(int id_fact) {
        this.id_fact = id_fact;
    }
}
