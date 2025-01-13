package com.example.examenjava;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Ingredient ing1 = new Ingredient("viande", 100);
        Ingredient ing2 = new Ingredient("pruneaux", 200);
        Ingredient ing3 = new Ingredient("possion", 300);
        Ingredient ing4 = new Ingredient("cartote", 400);
        Ingredient ing5 = new Ingredient("pomme de terre", 500);
        Ingredient ing6 = new Ingredient("olive", 600);

        List<IngredientPlat> ingredientPlats1 = new ArrayList<>();
        ingredientPlats1.add(new IngredientPlat(250,ing1));
        ingredientPlats1.add(new IngredientPlat(1,ing2));

        List<IngredientPlat> ingredientPlats2 = new ArrayList<>();
        ingredientPlats2.add(new IngredientPlat(250,ing3));
        ingredientPlats2.add(new IngredientPlat(1,ing4));
        ingredientPlats2.add(new IngredientPlat(1,ing5));
        ingredientPlats2.add(new IngredientPlat(1,ing6));

        PlatPrincipal plat1 = new PlatPrincipal("tajine de viande & pruneaux", ingredientPlats1);
        PlatPrincipal plat2 = new PlatPrincipal("tajine de poulet & legumes", ingredientPlats2);

        Supplement supplement1 = new Supplement("frites");
        Supplement supplement2 = new Supplement("boission");
        Supplement supplement3 = new Supplement("Jus d'orange marocain");
        Supplement supplement4 = new Supplement("Salade marocaine");

        List<SupplementRepat> supplementRepats1 = new ArrayList<>();
        supplementRepats1.add(new SupplementRepat(11, supplement1));
        supplementRepats1.add(new SupplementRepat(12, supplement2));

        List<SupplementRepat> supplementRepats2 = new ArrayList<>();
        supplementRepats2.add(new SupplementRepat(13, supplement3));
        supplementRepats2.add(new SupplementRepat(14, supplement4));

        Repat repat1 = new Repat(plat1,supplementRepats1);
        Repat repat2 = new Repat(plat2, supplementRepats2);

        List<Repat> repats = new ArrayList<>();
        repats.add(repat1);
        repats.add(repat2);

        Client client = new Client(1, "Ali Baba");

        Commande commande = new Commande(client, repats);
    }
}
