package com.example.testing.Models;

public class Dcommande {
    public int id_detailCom;
    public int quantite;
    public  String produit;
    public  String unite;
    public String image_produit;
    public  int prix;

    public Dcommande() {
    }

    public Dcommande(int id_detailCom, int quantite, String produit, String unite, String image_produit, int prix) {
        this.id_detailCom = id_detailCom;
        this.quantite = quantite;
        this.produit = produit;
        this.unite = unite;
        this.image_produit = image_produit;
        this.prix = prix;
    }

    public int getId_detailCom() {
        return id_detailCom;
    }

    public void setId_detailCom(int id_detailCom) {
        this.id_detailCom = id_detailCom;
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
}
