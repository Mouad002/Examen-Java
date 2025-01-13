package com.example.examenjava;

import java.util.List;

public class PlatPrincipal {
    private List<IngredientPlat> ingredients;

    public double calculerPrix() {
        return ingredients.stream()
                .mapToDouble(ingredientPlat -> ingredientPlat.getIngredient().getPrix() * ingredientPlat.getQuantite())
                .sum();
    }




}
