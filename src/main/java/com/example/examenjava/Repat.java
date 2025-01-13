package com.example.examenjava;

import java.util.List;

public class Repat {
    private int id;
    private PlatPrincipal platPrincipal;
    private List<SupplementRepat> supplements;

    // Constructor, getters, and setters
    public Repat(int id, PlatPrincipal platPrincipal, List<SupplementRepat> supplements) {
        this.id = id;
        this.platPrincipal = platPrincipal;
        this.supplements = supplements;
    }

    public Repat(PlatPrincipal platPrincipal, List<SupplementRepat> supplements) {
        this.platPrincipal = platPrincipal;
        this.supplements = supplements;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PlatPrincipal getPlatPrincipal() {
        return platPrincipal;
    }

    public void setPlatPrincipal(PlatPrincipal platPrincipal) {
        this.platPrincipal = platPrincipal;
    }

    public List<SupplementRepat> getSupplements() {
        return supplements;
    }

    public void setSupplements(List<SupplementRepat> supplements) {
        this.supplements = supplements;
    }

    public double calculerTotalRepat() {
        double platPrix = platPrincipal.calculerPrix();
        double supplementsPrix = supplements.stream()
                .mapToDouble(supplementRepat -> supplementRepat.getQuantite() * supplementRepat.getSupplement().getId()) // Assuming price logic here
                .sum();
        return platPrix + supplementsPrix;
    }
}
