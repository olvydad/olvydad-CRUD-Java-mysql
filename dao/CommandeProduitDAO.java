
package org.final_projet.dao;
import java.sql.*;
import org.final_projet.data.ConnectionDB;
import org.final_projet.entites.CommandeProduit;
public class CommandeProduitDAO {
    
    private final Connection con = ConnectionDB.connection_db();
    public void ajouterProduit(CommandeProduit cp){
        String ajouterP ="INSERT INTO commande_produit (id_commande, id_produit, quantite)\n" +
"VALUES (?, ?, ?)";
        try {
            PreparedStatement ps= con.prepareStatement(ajouterP);
            ps.setInt(1, cp.getId_C());
            ps.setInt(2, cp.getId_P());
            ps.setInt(3, cp.getQuantite());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void supprimerProduit(int id){
        String suprrimerP = "DELETE commande_produit WHERE id =?";
        try {
            PreparedStatement ps = con.prepareCall(suprrimerP);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
