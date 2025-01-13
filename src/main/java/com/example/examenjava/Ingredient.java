package com.example.examenjava;

public class Ingredient {
    private int id;
    private String nom;
    private double prix;

    // Constructors, getters, and setters
    public Ingredient(int id, String nom, double prix) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
    }

    public Ingredient(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    // Getters and setters
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

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
