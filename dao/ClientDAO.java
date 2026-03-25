package org.final_projet.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.final_projet.data.ConnectionDB;
import org.final_projet.entites.Client;

public class ClientDAO {

    Client c;
    List<Client> liste = new ArrayList<>();
//AJOUT D'EMPLOYE

    public static boolean Ajoute(Client c) {
        boolean saved = false;
        String sql = "INSERT INTO client(nom,prenom,adresse,telephone)VALUES(?,?,?,?)";
        try {
            Connection con = ConnectionDB.connection_db();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, c.getNom());
            ps.setString(2, c.getPrenom());
            ps.setString(3, c.getAdresse());
            ps.setInt(4, c.getTelephone());
            saved = ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            saved = false;
        }
        return saved;
    }

    //AFFICHAGE DE LA LISTE DES EMPLOYE
    public static List<Client> AfficheAll() {
        List<Client> liste = new ArrayList<>();
        String sql = "SELECT * FROM client";
        try {
            Connection con = ConnectionDB.connection_db();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Client c = new Client();
                c.setId(rs.getInt("id"));
                c.setNom(rs.getString("nom"));
                c.setPrenom(rs.getString("prenom"));
                c.setAdresse(rs.getString("adresse"));
                c.setTelephone(rs.getInt("telephone"));
                liste.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return liste;
    }

    //AFFICHAGE D'EMPLOYE PRA ID
    public static Client AfficheId(int id) {
        Client c = null;
        try {
            String sql = "SELECT * FROM client WHERE id=? ";
            Connection con = ConnectionDB.connection_db();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                c = new Client();
                c.setId(rs.getInt("id"));
                c.setNom(rs.getString("nom"));
                c.setPrenom(rs.getString("prenom"));
                c.setAdresse(rs.getString("adresse"));
                c.setTelephone(rs.getInt("telephone"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return c;
    }
//AFFICHAGE D'EMPLOYE PRA NOM

    public static Client AfficheNom(String nom) {
        Client c = null;
        try {
            String sql = "SELECT * FROM client WHERE nom LIKE? ";
            Connection con = ConnectionDB.connection_db();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + nom + "%");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                c = new Client();
                c.setId(rs.getInt("id"));
                c.setNom(rs.getString("nom"));
                c.setPrenom(rs.getString("prenom"));
                c.setAdresse(rs.getString("adresse"));
                c.setTelephone(rs.getInt("telephone"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return c;
    }

    //MODIFFICATION D'EMPLOYE
    public static void Modifie(Client c) {
        String sql = "UPDATE employe set nom=?,prenom=?,poste=?,salaire=? where id=?";
        try {
            Connection con = ConnectionDB.connection_db();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, c.getNom());
            ps.setString(2, c.getPrenom());
            ps.setString(3, c.getAdresse());
            ps.setInt(4, c.getTelephone());
            ps.setInt(5, c.getId());
            ps.executeUpdate();
            System.out.println("Cient modiffier avec succes!");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
//SUPPRESSION PAR ID

    public static void Suprime(int id) {
        Client c = new Client();
        try {
            Connection con = ConnectionDB.connection_db();
            String sql = "DELETE from client WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Client supprimer avec succes!");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
