package com.example.examenjava;

import java.util.List;

public class Client {
    private int id;
    private String nom;
    private List<Commande> commandes;

    // Constructor, getters, and setters
    public Client(int id, String nom, List<Commande> commandes) {
        this.id = id;
        this.nom = nom;
        this.commandes = commandes;
    }

    public Client(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Client(String nom) {

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

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }
}

