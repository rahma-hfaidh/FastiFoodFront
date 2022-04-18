package com.example.testing.Models;

public class CALENDARJ {
    public int quantite;
    public  String produit;
    public  String unite;
    public String image_produit;
    public  int prix;
    public String date;
    public int heure;

    public CALENDARJ(int quantite, String produit, String unite, String image_produit, int prix, int heure,String date) {
        this.quantite = quantite;
        this.produit = produit;
        this.unite = unite;
        this.image_produit = image_produit;
        this.prix = prix;
        this.heure = heure;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getProduit() {
        return produit;
    }

    public void setProduit(String produit) {
        this.produit = produit;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public String getImage_produit() {
        return image_produit;
    }

    public void setImage_produit(String image_produit) {
        this.image_produit = image_produit;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getHeure() {
        return heure;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }
}
