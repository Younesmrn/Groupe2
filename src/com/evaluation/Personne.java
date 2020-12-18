package com.evaluation;

import com.opencsv.bean.CsvBindByName;


public class Personne  {

    @CsvBindByName
    private String nom;
    @CsvBindByName
    private String prenom;
    @CsvBindByName
    private String tel;
    @CsvBindByName
    private String mail;

    public Personne() {
    }

    public Personne(String nom, String prenom, String tel, String mail) {
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.mail = mail;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }


}
