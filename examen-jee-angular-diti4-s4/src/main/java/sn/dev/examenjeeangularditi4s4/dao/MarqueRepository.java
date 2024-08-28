package sn.dev.examenjeeangularditi4s4.dao;

import sn.dev.examenjeeangularditi4s4.entity.DB;
import sn.dev.examenjeeangularditi4s4.entity.Marque;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MarqueRepository {

    public void insertMarque(Marque marque) {
        DB db = new DB();
        String sql = "INSERT INTO marque (libelle) VALUES (?)";
        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, marque.getLibelle());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteMarque(int id) {
        DB db = new DB();
        String sql = "DELETE FROM marque WHERE id = ?";
        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Marque> selectAllMarques() {
        DB db = new DB();
        List<Marque> marques = new ArrayList<>();
        String sql = "SELECT * FROM marque";
        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Marque marque = new Marque(
                        rs.getInt("id"),
                        rs.getString("libelle")
                );
                marques.add(marque);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return marques;
    }

    public void updateMarque(Marque marque) {
        DB db = new DB();
        String sql = "UPDATE marque SET libelle = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, marque.getLibelle());
            preparedStatement.setInt(2, marque.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Marque getElementByID(int id) {
        DB db = new DB();
        String sql = "SELECT * FROM marque WHERE id = ?";
        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return new Marque(
                        rs.getInt("id"),
                        rs.getString("libelle")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Marque> search(String mot) {
        DB db = new DB();
        List<Marque> marques = new ArrayList<>();
        String sql = "SELECT * FROM marque WHERE libelle LIKE ?";
        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, "%" + mot + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Marque marque = new Marque(
                        rs.getInt("id"),
                        rs.getString("libelle")
                );
                marques.add(marque);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return marques;
    }
}