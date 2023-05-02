package com.example.gsb_visite;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Praticien implements Serializable {
    @SerializedName("id")
    private int id;
    @SerializedName("nom")
    private String nom;
    @SerializedName("prenom")
    private String prenom;
    @SerializedName("mail")
    private String email;
    @SerializedName("telephone")
    private String telephone;
    @SerializedName("rue")
    private String rue;
    @SerializedName("codePostal")
    private String codePostal;
    @SerializedName("ville")
    private String ville;
    @SerializedName("coeffNotoriete")
    private String coef_Notoriete;
    @SerializedName("visiteurs")
    private ArrayList<String> visiteurs;
    @SerializedName("visites")
    private ArrayList<String> visites;

    public Praticien(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCoef_Notoriete() {
        return coef_Notoriete;
    }

    public void setCoef_Notoriete(String coef_Notoriete) {
        this.coef_Notoriete = coef_Notoriete;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<String> getVisiteurs() {
        return visiteurs;
    }

    public ArrayList<String> getVisites() {
        return visites;
    }
}