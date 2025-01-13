package com.example.examenjava;
import java.util.List;

public class Commande {
    private int id;
    private Client client;
    private List<Repat> repas;

    // Constructor, getters, and setters
    public Commande(int id, Client client, List<Repat> repas) {
        this.id = id;
        this.client = client;
        this.repas = repas;
    }

    public Commande(Client client, List<Repat> repas) {
        this.client = client;
        this.repas = repas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Repat> getRepas() {
        return repas;
    }

    public void setRepas(List<Repat> repas) {
        this.repas = repas;
    }

    public double calculerTotalCommand() {
        return repas.stream()
                .mapToDouble(Repat::calculerTotalRepat)
                .sum();
    }
}
