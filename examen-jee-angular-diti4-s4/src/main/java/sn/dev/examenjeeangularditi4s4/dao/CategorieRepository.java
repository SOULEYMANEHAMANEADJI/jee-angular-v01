package sn.dev.examenjeeangularditi4s4.dao;

import sn.dev.examenjeeangularditi4s4.entity.Categorie;
import sn.dev.examenjeeangularditi4s4.entity.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategorieRepository {

    public void insertCategorie(Categorie categorie) {
        DB db = new DB();
        String sql = "INSERT INTO categorie (libelle) VALUES (?)";
        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, categorie.getLibelle());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteCategorie(int id) {
        DB db = new DB();
        String sql = "DELETE FROM categorie WHERE id = ?";
        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Categorie> selectAllCategories() {
        DB db = new DB();
        List<Categorie> categories = new ArrayList<>();
        String sql = "SELECT * FROM categorie";
        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Categorie categorie = new Categorie(
                        rs.getInt("id"),
                        rs.getString("libelle")
                );
                categories.add(categorie);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }

    public void updateCategorie(Categorie categorie) {
        DB db = new DB();
        String sql = "UPDATE categorie SET libelle = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, categorie.getLibelle());
            preparedStatement.setInt(2, categorie.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Categorie getElementByID(int id) {
        DB db = new DB();
        String sql = "SELECT * FROM categorie WHERE id = ?";
        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return new Categorie(
                        rs.getInt("id"),
                        rs.getString("libelle")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Categorie> search(String mot) {
        DB db = new DB();
        List<Categorie> categories = new ArrayList<>();
        String sql = "SELECT * FROM categorie WHERE libelle LIKE ?";
        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, "%" + mot + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Categorie categorie = new Categorie(
                        rs.getInt("id"),
                        rs.getString("libelle")
                );
                categories.add(categorie);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }
}
