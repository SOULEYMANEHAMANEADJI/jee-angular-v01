package sn.dev.examenjeeangularditi4s4.dao;
import sn.dev.examenjeeangularditi4s4.entity.DB;
import sn.dev.examenjeeangularditi4s4.entity.Produit;
import sn.dev.examenjeeangularditi4s4.entity.Marque;
import sn.dev.examenjeeangularditi4s4.entity.Categorie;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProduitRepository {

    public void insertProduit(Produit produit) {
        DB db = new DB();
        String sql = "INSERT INTO produit (libelle, quantite, categorie_id, marque_id) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, produit.getLibelle());
            preparedStatement.setInt(2, produit.getQuantite());
            preparedStatement.setInt(3, produit.getCategorie().getId());
            preparedStatement.setInt(4, produit.getMarque().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteProduit(int id) {
        DB db = new DB();
        String sql = "DELETE FROM produit WHERE id = ?";
        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Produit> selectAllProduits() {
        DB db = new DB();
        List<Produit> produits = new ArrayList<>();
        String sql = "SELECT p.id, p.libelle, p.quantite, c.libelle AS categorie, m.libelle AS marque " +
                "FROM produit p " +
                "JOIN categorie c ON p.categorie_id = c.id " +
                "JOIN marque m ON p.marque_id = m.id";
        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Produit produit = new Produit(
                        rs.getInt("id"),
                        rs.getString("libelle"),
                        rs.getInt("quantite"),
                        new Categorie(rs.getInt("categorie_id"), rs.getString("categorie")),
                        new Marque(rs.getInt("marque_id"), rs.getString("marque"))
                );
                produits.add(produit);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return produits;
    }

    public void updateProduit(Produit produit) {
        DB db = new DB();
        String sql = "UPDATE produit SET libelle = ?, quantite = ?, categorie_id = ?, marque_id = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, produit.getLibelle());
            preparedStatement.setInt(2, produit.getQuantite());
            preparedStatement.setInt(3, produit.getCategorie().getId());
            preparedStatement.setInt(4, produit.getMarque().getId());
            preparedStatement.setInt(5, produit.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Produit getElementByID(int id) {
        DB db = new DB();
        String sql = "SELECT p.id, p.libelle, p.quantite, c.libelle AS categorie, m.libelle AS marque " +
                "FROM produit p " +
                "JOIN categorie c ON p.categorie_id = c.id " +
                "JOIN marque m ON p.marque_id = m.id WHERE p.id = ?";
        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return new Produit(
                        rs.getInt("id"),
                        rs.getString("libelle"),
                        rs.getInt("quantite"),
                        new Categorie(rs.getInt("categorie_id"), rs.getString("categorie")),
                        new Marque(rs.getInt("marque_id"), rs.getString("marque"))
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Produit> search(String mot) {
        DB db = new DB();
        List<Produit> produits = new ArrayList<>();
        String sql = "SELECT p.id, p.libelle, p.quantite, c.libelle AS categorie, m.libelle AS marque " +
                "FROM produit p " +
                "JOIN categorie c ON p.categorie_id = c.id " +
                "JOIN marque m ON p.marque_id = m.id " +
                "WHERE p.libelle LIKE ?";
        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, "%" + mot + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Produit produit = new Produit(
                        rs.getInt("id"),
                        rs.getString("libelle"),
                        rs.getInt("quantite"),
                        new Categorie(rs.getInt("categorie_id"), rs.getString("categorie")),
                        new Marque(rs.getInt("marque_id"), rs.getString("marque"))
                );
                produits.add(produit);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return produits;
    }
}