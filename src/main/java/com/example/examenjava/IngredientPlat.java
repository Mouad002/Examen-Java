package com.example.examenjava;

public class IngredientPlat {
    private int id;
    private int quantite;
    private Ingredient ingredient;

    // Constructor, getters, and setters
    public IngredientPlat(int quantite, Ingredient ingredient) {
        this.quantite = quantite;
        this.ingredient = ingredient;
    }

    public IngredientPlat(int id, int quantite, Ingredient ingredient) {
        this.id = id;
        this.quantite = quantite;
        this.ingredient = ingredient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
}