package com.example.testing;

import com.google.gson.annotations.SerializedName;

public class Panier {

    @SerializedName("id_prod")
    public int id_prod;

    @SerializedName("nomProd")
    public String nomProd;

    @SerializedName("imageProd")
    public int imageProd;

    @SerializedName("nomRest")
    public String nomRest;

    @SerializedName("prixProd")
    public float prixProd;

    @SerializedName("quantite")
    public int quantite;

    public Panier() {
    }

    public Panier(int id_prod, String nomProd, int imageProd, String designation, float prixProd, int quantite) {
        this.id_prod = id_prod;
        this.nomProd = nomProd;
        this.imageProd = imageProd;
        this.nomRest = designation;
        this.prixProd = prixProd;
        this.quantite = quantite;
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public String getNomProd() {
        return nomProd;
    }

    public void setNomProd(String nomProd) {
        this.nomProd = nomProd;
    }

    public int getImageProd() {
        return imageProd;
    }

    public void setImageProd(int imageProd) {
        this.imageProd = imageProd;
    }

    public String getDesignation() {
        return nomRest;
    }

    public void setDesignation(String designation) {
        this.nomRest = designation;
    }

    public float getPrixProd() {
        return prixProd;
    }

    public void setPrixProd(float prixProd) {
        this.prixProd = prixProd;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
