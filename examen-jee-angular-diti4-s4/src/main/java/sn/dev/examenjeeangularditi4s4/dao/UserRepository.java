package sn.dev.examenjeeangularditi4s4.dao;

import sn.dev.examenjeeangularditi4s4.entity.DB;
import sn.dev.examenjeeangularditi4s4.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    // Méthode pour insérer un utilisateur
    public void insertUser(User user) {
        DB db = new DB();
        String sql = "INSERT INTO user (nom, prenom, age) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, user.getNom());
            preparedStatement.setString(2, user.getPrenom());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Méthode pour supprimer un utilisateur par ID
    public void deleteUser(int id) {
        DB db = new DB();
        String sql = "DELETE FROM user WHERE id = ?";
        try (PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Méthode pour obtenir tous les utilisateurs
    public List<User> selectAllUsers() {
        DB db = new DB();
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM user";
        try (PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getInt("age")
                );
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    // Méthode pour mettre à jour un utilisateur
    public void updateUser(User user) {
        DB db = new DB();
        String sql = "UPDATE user SET nom = ?, prenom = ?, age = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, user.getNom());
            preparedStatement.setString(2, user.getPrenom());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.setInt(4, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Méthode pour obtenir un utilisateur par ID
    public User getElementByID(int id) {
        DB db = new DB();
        String sql = "SELECT * FROM user WHERE id = ?";
        try (PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    return new User(
                            rs.getInt("id"),
                            rs.getString("nom"),
                            rs.getString("prenom"),
                            rs.getInt("age")
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    // Méthode pour rechercher des utilisateurs par nom
    public List<User> search(String mot) {
        DB db = new DB();
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM user WHERE nom LIKE ?";
        try (PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, "%" + mot + "%");
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    User user = new User(
                            rs.getInt("id"),
                            rs.getString("nom"),
                            rs.getString("prenom"),
                            rs.getInt("age")
                    );
                    users.add(user);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
}