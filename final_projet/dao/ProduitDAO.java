
package org.final_projet.dao;
import org.final_projet.data.ConnectionDB;
import org.final_projet.entites.Produit;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduitDAO {
    static final Connection con= ConnectionDB.connection_db();;
    public static void ajouterProduit(Produit p){
  String ajouter = "INSERT INTO produit (nom,categorie,stock,prix)VALUES(?,?,?,?) " ;
 
        try {
            PreparedStatement ps = con.prepareStatement(ajouter);
            ps.setString(1,p.getNom());
            ps.setString(2, p.getCategorie());
            ps.setInt(3, p.getStock ());
            ps.setDouble(4, p.getPrix());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
}

   public static List<Produit> afficherProduit(){
       String afficher = "SELECT * FROM produit";
       List<Produit> ListeP=new ArrayList<>();
       Produit p; 
       try {
          Statement st=con.createStatement();
          ResultSet rs =st.executeQuery(afficher);
          while(rs.next()){
             p=new Produit();
              p.setId(rs.getInt("id"));
              p.setNom(rs.getString("nom"));
              p.setStock(rs.getInt("stock"));
              p.setCategorie(rs.getString("categorie"));
              p.setPrix(rs.getDouble("prix"));
              ListeP.add(p);
          }
       } catch (SQLException e) {
           System.out.println(e);
       }
 return ListeP;
  }
    
    public static void modifierProduit(Produit p){
        String modifier ="UPDATE TABLE produit set nom=?,categorie=?,stock=?,prix=? where id=?";
        try {
            PreparedStatement ps =con.prepareStatement(modifier);
            ps.setString(1, p.getNom());
            ps.setString(1, p.getCategorie());
            ps.setInt(3, p.getStock());
            ps.setDouble(4, p.getPrix());
            ps.setInt(5, p.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }  
    }
    public static void supprimerProduit(int id){
            String supprimer = "DELETE FROM produit WHERE id=? ";
            try {
            PreparedStatement ps = con.prepareStatement(supprimer);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
                System.out.println("e");
        }
        } 
     public static Produit AfficheId(int id) {
        Produit e = null;
        try {
            String sql = "SELECT * FROM employe WHERE id=? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e = new Produit();
                e.setId(rs.getInt("id"));
                e.setNom(rs.getString("nom"));
                e.setCategorie(rs.getString("categorie"));
                e.setStock(rs.getInt("stock"));
                e.setPrix(rs.getDouble("prix"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return e;
    }
//AFFICHAGE DE PRODUIT PRA NOM
    public static Produit AfficheNom(String nom) {
        Produit e = null;
        try {
            String sql = "SELECT * FROM employe WHERE nom LIKE? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + nom + "%");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e = new Produit();
                e.setId(rs.getInt("id"));
                e.setNom(rs.getString("nom"));
                e.setCategorie(rs.getString("categorie"));
                e.setStock(rs.getInt("stock"));
                e.setPrix(rs.getDouble("prix"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return e;
    }

}