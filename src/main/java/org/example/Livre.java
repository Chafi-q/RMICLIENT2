package org.example;

import java.io.Serializable;

public class Livre implements Serializable {
    private static final long serialVersionUID = 1L;
    private long ISBN;
    private String auteur;
    private String titre;

    public Livre(long ISBN, String auteur, String titre) {
        this.ISBN = ISBN;
        this.auteur = auteur;
        this.titre = titre;
    }

    public Livre() {
    }

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
    @Override
    public String toString() {
        return "Livre{" +
                "ISBN=" + ISBN +
                ", auteur='" + auteur + '\'' +
                ", titre='" + titre + '\'' +
                '}';
    }

}