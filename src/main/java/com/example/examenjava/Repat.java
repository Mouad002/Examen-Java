package com.example.examenjava;

import java.util.List;

public class Repat {
    private PlatPrincipal platPrincipal;
    private List<Supplement> supplements;

    public double calculerTotal() {
        // Prix du plat principal
        double total = platPrincipal != null ? platPrincipal.calculerPrix() : 0.0;

        // Ajouter le prix des suppléments
        total += supplements.stream()
                .mapToDouble(Supplement::getPrix)
                .sum();

        return total;
    }
}
