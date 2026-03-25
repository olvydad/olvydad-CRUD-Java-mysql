package org.final_projet.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.final_projet.data.ConnectionDB;
import org.final_projet.entites.Employe;

public class EmployeDAO {

    Employe e;
    List<Employe> liste = new ArrayList<>();
//AJOUT D'EMPLOYE
    public static boolean Ajoute(Employe e) {
        boolean saved = false;
        String sql = "INSERT INTO Employe(nom,prenom,poste,salaire)VALUES(?,?,?,?)";
        try {
            Connection con = ConnectionDB.connection_db();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, e.getNom());
            ps.setString(2, e.getPrenom());
            ps.setString(3, e.getPoste());
            ps.setDouble(4, e.getSalaire());
            saved = ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            saved = false;
        }
        return saved;
    }
    //AFFICHAGE DE LA LISTE DES EMPLOYE
    public static List<Employe> AfficheAll() {
        List<Employe> liste = new ArrayList<>();
        String sql = "SELECT * FROM employe";
        try {
            Connection con = ConnectionDB.connection_db();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Employe e = new Employe();
                e.setId(rs.getInt("id"));
                e.setNom(rs.getString("nom"));
                e.setPrenom(rs.getString("prenom"));
                e.setPoste(rs.getString("poste"));
                e.setSalaire(rs.getDouble("salaire"));
                liste.add(e);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return liste;
    }
    //AFFICHAGE D'EMPLOYE PRA ID
    public static Employe AfficheId(int id) {
        Employe e = null;
        try {
            String sql = "SELECT * FROM employe WHERE id=? ";
            Connection con = ConnectionDB.connection_db();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e = new Employe();
                e.setId(rs.getInt("id"));
                e.setNom(rs.getString("nom"));
                e.setPrenom(rs.getString("prenom"));
                e.setPoste(rs.getString("poste"));
                e.setSalaire(rs.getDouble("salaire"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return e;
    }
//AFFICHAGE D'EMPLOYE PRA NOM
    public static Employe AfficheNom(String nom) {
        Employe e = null;
        try {
            String sql = "SELECT * FROM employe WHERE nom LIKE? ";
            Connection con = ConnectionDB.connection_db();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + nom + "%");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e = new Employe();
                e.setId(rs.getInt("id"));
                e.setNom(rs.getString("nom"));
                e.setPrenom(rs.getString("prenom"));
                e.setPoste(rs.getString("poste"));
                e.setSalaire(rs.getDouble("salaire"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return e;
    }

    //MODIFFICATION D'EMPLOYE
    public static void Modifie(Employe e) {
        String sql = "UPDATE employe set nom=?,prenom=?,poste=?,salaire=? where id=?";
        try {
            Connection con = ConnectionDB.connection_db();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, e.getNom());
            ps.setString(2, e.getPrenom());
            ps.setString(3, e.getPoste());
            ps.setDouble(4, e.getSalaire());
            ps.setInt(5, e.getId());
            ps.executeUpdate();
            System.out.println("Employe modiffier avec succes!");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
//SUPPRESSION PAR ID
    public static void Suprime(int id) {
        Employe e = new Employe();
        try {
            Connection con = ConnectionDB.connection_db();
            String sql = "DELETE from employe WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Employe supprimer avec succes!");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
