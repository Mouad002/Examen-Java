package com.example.examenjava;

public class Supplement {
    private int id;
    private String nom;

    // Constructor, getters, and setters
    public Supplement(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Supplement(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}

