package com.example.examenjava;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IngredientDAO implements DAO<Ingredient>{
    @Override
    public void ajouter(Ingredient ingredient) {
        String query = "INSERT INTO ingredients (nom, prix) VALUES (?, ?)";
        try (Connection connection = SingletonConnexionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, ingredient.getNom());
            preparedStatement.setDouble(2, ingredient.getPrix());
            preparedStatement.executeUpdate();
            System.out.println("Ingredient added successfully.");

        } catch (SQLException e) {
            System.err.println("Error while adding ingredient: " + e.getMessage());
        }

    }

    @Override
    public void modifier(Ingredient ingredient) {
        String query = "UPDATE ingredients SET nom = ?, prix = ? WHERE id = ?";
        try (Connection connection = SingletonConnexionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, ingredient.getNom());
            preparedStatement.setDouble(2, ingredient.getPrix());
            preparedStatement.setInt(3, ingredient.getId());
            preparedStatement.executeUpdate();
            System.out.println("Ingredient updated successfully.");

        } catch (SQLException e) {
            System.err.println("Error while updating ingredient: " + e.getMessage());
        }
    }

    @Override
    public void supprimer(int id) {
        String query = "DELETE FROM ingredients WHERE id = ?";
        try (Connection connection = SingletonConnexionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Ingredient deleted successfully.");

        } catch (SQLException e) {
            System.err.println("Error while deleting ingredient: " + e.getMessage());
        }
    }

    @Override
    public List<Ingredient> lire() {
        List<Ingredient> ingredients = new ArrayList<>();
        String query = "SELECT * FROM ingredients";
        try (Connection connection = SingletonConnexionDB.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                double prix = resultSet.getDouble("prix");
                ingredients.add(new Ingredient(id, nom, prix));
            }

        } catch (SQLException e) {
            System.err.println("Error while retrieving ingredients: " + e.getMessage());
        }
        return ingredients;
    }
}
