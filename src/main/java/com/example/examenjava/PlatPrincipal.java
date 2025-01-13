package com.example.examenjava;

import java.util.List;

public class PlatPrincipal {
    private int id;
    private String nom;
    private List<IngredientPlat> ingredients;

    // Constructor, getters, and setters
    public PlatPrincipal(int id, String nom, List<IngredientPlat> ingredients) {
        this.id = id;
        this.nom = nom;
        this.ingredients = ingredients;
    }

    public PlatPrincipal(String nom, List<IngredientPlat> ingredients) {
        this.nom = nom;
        this.ingredients = ingredients;
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

    public List<IngredientPlat> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientPlat> ingredients) {
        this.ingredients = ingredients;
    }

    public double calculerPrix() {
        return ingredients.stream()
                .mapToDouble(ingredientPlat -> ingredientPlat.getQuantite() * ingredientPlat.getIngredient().getPrix())
                .sum();
    }
}

