package com.example.examenjava;
import java.util.List;

public class Commande {
    private List<Repat> repat;

    // Méthode pour calculer le total de la commande
    public double calculerTotalCommande() {
        return repat.stream()
                .mapToDouble(Repat::calculerTotal)
                .sum();
    }
}
