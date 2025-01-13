package com.example.examenjava;

public class SupplementRepat {
    private int quantite;
    private Supplement supplement;

    // Constructor, getters, and setters
    public SupplementRepat(int quantite, Supplement supplement) {
        this.quantite = quantite;
        this.supplement = supplement;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Supplement getSupplement() {
        return supplement;
    }

    public void setSupplement(Supplement supplement) {
        this.supplement = supplement;
    }
}
