package com.example.examenjava;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlatPrincipalDao implements DAO<PlatPrincipal>{
    @Override
    public void ajouter(PlatPrincipal plat) {
        String query = "INSERT INTO plats_principaux (nom) VALUES (?)";
        try (Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, plat.getNom());
            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int platId = generatedKeys.getInt(1);
                addIngredientsToPlat(platId, plat.getIngredients());
            }

            System.out.println("Plat principal added successfully.");

        } catch (SQLException e) {
            System.err.println("Error while adding plat principal: " + e.getMessage());
        }
    }

    @Override
    public void modifier(PlatPrincipal plat) {
        String query = "UPDATE plats_principaux SET nom = ? WHERE id = ?";
        try (Connection connection = SingletonConnexionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, plat.getNom());
            preparedStatement.setInt(2, plat.getId());
            preparedStatement.executeUpdate();

            deleteIngredientsFromPlat(plat.getId());
            addIngredientsToPlat(plat.getId(), plat.getIngredients());

            System.out.println("Plat principal updated successfully.");

        } catch (SQLException e) {
            System.err.println("Error while updating plat principal: " + e.getMessage());
        }
    }

    @Override
    public void supprimer(int id) {
        String query = "DELETE FROM plats_principaux WHERE id = ?";
        try (Connection connection = SingletonConnexionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            deleteIngredientsFromPlat(id);

            System.out.println("Plat principal deleted successfully.");

        } catch (SQLException e) {
            System.err.println("Error while deleting plat principal: " + e.getMessage());
        }
    }

    @Override
    public List<PlatPrincipal> lire() {
        List<PlatPrincipal> plats = new ArrayList<>();
        String query = "SELECT * FROM plats_principaux";
        try (Connection connection = SingletonConnexionDB.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                List<IngredientPlat> ingredients = getIngredientsForPlat(id);
                plats.add(new PlatPrincipal(id, nom, ingredients));
            }

        } catch (SQLException e) {
            System.err.println("Error while retrieving plats principaux: " + e.getMessage());
        }
        return plats;
    }

    private void addIngredientsToPlat(int platId, List<IngredientPlat> ingredients) {
        String query = "INSERT INTO ingredients_plat (plat_id, ingredient_id, quantity) VALUES (?, ?, ?)";
        try (Connection connection = SingletonConnexionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            for (IngredientPlat ingredient : ingredients) {
                preparedStatement.setInt(1, platId);
                preparedStatement.setInt(2, ingredient.getId());
                preparedStatement.setDouble(3, ingredient.getQuantite());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();

        } catch (SQLException e) {
            System.err.println("Error while adding ingredients to plat: " + e.getMessage());
        }
    }

    private void deleteIngredientsFromPlat(int platId) {
        String query = "DELETE FROM ingredients_plat WHERE plat_id = ?";
        try (Connection connection = SingletonConnexionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, platId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error while deleting ingredients from plat: " + e.getMessage());
        }
    }

    private List<IngredientPlat> getIngredientsForPlat(int platId) {
        List<IngredientPlat> ingredients = new ArrayList<>();
        String query = "SELECT * FROM ingredients_plat WHERE plat_id = ?";
        try (Connection connection = SingletonConnexionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, platId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int ingredientId = resultSet.getInt("ingredient_id");
                int quantity = resultSet.getInt("quantity");
                ingredients.add(new IngredientPlat(ingredientId, quantity, null));
            }

        } catch (SQLException e) {
            System.err.println("Error while retrieving ingredients for plat: " + e.getMessage());
        }
        return ingredients;
    }
}
