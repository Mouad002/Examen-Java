package com.example.examenjava;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDao implements DAO<Client>{
    @Override
    public void ajouter(Client client) {
        String query = "INSERT INTO clients (nom) VALUES (?)";
        try (Connection connection = SingletonConnexionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, client.getNom());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error while adding client: " + e.getMessage());
        }
    }

    @Override
    public void modifier(Client client) {
        String query = "UPDATE clients SET nom = ? WHERE id = ?";
        try (Connection connection = SingletonConnexionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, client.getNom());
            preparedStatement.setInt(2, client.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error while updating client: " + e.getMessage());
        }
    }

    @Override
    public void supprimer(int id) {
        String query = "DELETE FROM clients WHERE id = ?";
        try (Connection connection = SingletonConnexionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error while deleting client: " + e.getMessage());
        }
    }

    @Override
    public List<Client> lire() {
        List<Client> clients = new ArrayList<>();
        String query = "SELECT * FROM clients";
        try (Connection connection = SingletonConnexionDB.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                clients.add(new Client(id, nom));
            }

        } catch (SQLException e) {
            System.err.println("Error while retrieving clients: " + e.getMessage());
        }
        return clients;
    }
}
