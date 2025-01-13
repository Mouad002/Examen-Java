package com.example.examenjava;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SupplementDAO implements DAO<Supplement>{
    @Override
    public void ajouter(Supplement supplement) {
        String query = "INSERT INTO supplements (nom) VALUES (?)";
        try (Connection connection = SingletonConnexionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, supplement.getNom());
            preparedStatement.executeUpdate();
            System.out.println("Supplement added successfully.");

        } catch (SQLException e) {
            System.err.println("Error while adding supplement: " + e.getMessage());
        }

    }

    @Override
    public void modifier(Supplement supplement) {
        String query = "UPDATE supplements SET nom = ? WHERE id = ?";
        try (Connection connection = SingletonConnexionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, supplement.getNom());
            preparedStatement.setInt(2, supplement.getId());
            preparedStatement.executeUpdate();
            System.out.println("Supplement updated successfully.");

        } catch (SQLException e) {
            System.err.println("Error while updating supplement: " + e.getMessage());
        }
    }

    @Override
    public void supprimer(int id) {
        String query = "DELETE FROM supplements WHERE id = ?";
        try (Connection connection = SingletonConnexionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Supplement deleted successfully.");

        } catch (SQLException e) {
            System.err.println("Error while deleting supplement: " + e.getMessage());
        }
    }

    @Override
    public List<Supplement> lire() {
        List<Supplement> supplements = new ArrayList<>();
        String query = "SELECT * FROM supplements";
        try (Connection connection = SingletonConnexionDB.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                supplements.add(new Supplement(id, nom));
            }

        } catch (SQLException e) {
            System.err.println("Error while retrieving supplements: " + e.getMessage());
        }
        return supplements;

    }
}
