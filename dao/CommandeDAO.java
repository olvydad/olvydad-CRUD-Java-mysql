
package org.final_projet.dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.final_projet.data.ConnectionDB;
import org.final_projet.entites.Client;
import org.final_projet.entites.Commande;
import org.final_projet.entites.Employe;
import org.final_projet.entites.Produit;

public class CommandeDAO {
static Connection conn = ConnectionDB.connection_db();
    
    private Commande mapper(ResultSet rs) throws SQLException {
        Commande c = new Commande();
        c.setId(rs.getInt("c.id"));
        c.setDateCmd(rs.getDate("date_cmd"));
        c.setMontant(rs.getDouble("montant"));
        c.setStatut(rs.getString("statut"));

        // On reconstruit aussi le Client et l'Employé
        // grâce aux colonnes ramenées par la jointure
        Client client = new Client();
        client.setId(rs.getInt("id_client"));
        client.setNom(rs.getString("cl.nom"));  // alias de la jointure
        c.setClient(client);

        Employe employe = new Employe();
        employe.setId(rs.getInt("id_employe"));
        employe.setNom(rs.getString("em.nom")); // alias de la jointure
        c.setEmploye(employe);

        return c;
    }

    // ─────────────────────────────────────────
    // SELECT avec JOIN : récupère toutes les commandes
    // avec le nom du client et de l'employé
    // ─────────────────────────────────────────
    private static final String SELECT_JOIN =
        "SELECT c.id, c.date_cmd, c.montant, c.statut, " +
        "       c.id_client,  cl.nom AS 'cl.nom', " +
        "       c.id_employe, em.nom AS 'em.nom' " +
        "FROM commande c " +
        "JOIN client  cl ON c.id_client  = cl.id " +
        "JOIN employe em ON c.id_employe = em.id ";
    // ↑ Notez l'espace à la fin — on pourra ajouter un WHERE facilement

    // ─────────────────────────────────────────
    // AJOUTER
    // On insère seulement dans la table commande
    // Les produits sont gérés séparément (table commande_produit)
    // ─────────────────────────────────────────
   
    public static void ajouter(Commande c) {
        String sql = "INSERT INTO commande (date_cmd, statut, id_client, id_employe) " +
                     "VALUES (?, ?, ?, ?)";

        try (
             // RETURN_GENERATED_KEYS → récupère l'id auto-généré par MariaDB
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setDate(1, new java.sql.Date(c.getDateCmd().getTime()));
            ps.setString(2, c.getStatut());
            ps.setInt(3, c.getClient().getId());
            ps.setInt(4, c.getEmploye().getId());
            ps.executeUpdate();

            // Récupérer l'id généré et l'affecter à l'objet
            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                c.setId(keys.getInt(1));
            }

            System.out.println("✅ Commande ajoutée avec id = " + c.getId());

        } catch (SQLException e) {
            System.out.println("❌ Erreur ajout commande : " + e.getMessage());
        }
    } 

   
    public Commande FicheCommande(int idCommande) throws SQLException {
        String sql = "SELECT cl.id AS client_id, cl.nom AS nom_client, "
           + "c.id AS commande_id, c.montant AS montant_total, "
           + "p.id AS produit_id, p.nom AS nom_produit, "
           + "cp.prix_unitaire, cp.quantite, "
           + "(cp.prix_unitaire * cp.quantite) AS prixTotal "
           + "FROM commande c "
           + "JOIN client cl ON c.id_client = cl.id "
           + "JOIN commande_produit cp ON c.id = cp.id_commande "
           + "JOIN produit p ON cp.id_produit = p.id "
           + "WHERE c.id = ?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idCommande);
        ResultSet rs = ps.executeQuery();

        Commande commande = null;

        while (rs.next()) {
            if (commande == null) {
                Client client = new Client();
                client.setId(rs.getInt("client_id"));
                client.setNom(rs.getString("nom_client"));

                commande = new Commande();
                commande.setId(rs.getInt("commande_id"));
                commande.setClient(client);
                commande.setMontant(rs.getDouble("montant_total"));
            }

            Produit produit = new Produit();
            produit.setId(rs.getInt("produit_id"));
            produit.setNom(rs.getString("nom_produit"));
            produit.setPrix(rs.getDouble("prix_unitaire"));
            produit.setQuantite(rs.getInt("quantite"));
            produit.setTotalProduit(rs.getDouble("prixTotal"));

            commande.getProduits().add(produit);
        }

        return commande;
    }

    
    
public void modifier(Commande c) {
        String sql = "UPDATE commande SET date_cmd=?, montant=?, statut=?, " +
                     "id_client=?, id_employe=? WHERE id=?";

        try (
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDate(1, new java.sql.Date(c.getDateCmd().getTime()));
            ps.setDouble(2, c.getMontant());
            ps.setString(3, c.getStatut());
            ps.setInt(4, c.getClient().getId());
            ps.setInt(5, c.getEmploye().getId());
            ps.setInt(6, c.getId());
            ps.executeUpdate();

            System.out.println("✅ Commande modifiée !");

        } catch (SQLException e) {
            System.out.println("❌ Erreur modification : " + e.getMessage());
        }
    }

    // ─────────────────────────────────────────
    // SUPPRIMER
    // MariaDB supprime aussi commande_produit automatiquement
    // grâce au ON DELETE CASCADE qu'on a mis dans le SQL
    // ─────────────────────────────────────────
   
    public void supprimer(int id) {
        String sql = "DELETE FROM commande WHERE id=?";

        try (
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("✅ Commande supprimée !");

        } catch (SQLException e) {
            System.out.println("❌ Erreur suppression : " + e.getMessage());
        }
    }

    // ─────────────────────────────────────────
    // RECHERCHER PAR ID avec JOIN
    // ─────────────────────────────────────────
    
    public Commande rechercherParId(int id) {
        // On réutilise SELECT_JOIN et on ajoute juste le WHERE
        String sql = SELECT_JOIN + "WHERE c.id = ?";

        try (
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) return mapper(rs); // on appelle notre méthode utilitaire

        } catch (SQLException e) {
            System.out.println("❌ Erreur recherche : " + e.getMessage());
        }
        return null;
    }

    // ─────────────────────────────────────────
    // LISTER TOUTES LES COMMANDES avec JOIN
    // ─────────────────────────────────────────
   
    public List<Commande> listerTous() {
        List<Commande> liste = new ArrayList<>();

        try (
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(SELECT_JOIN)) {

            while (rs.next()) liste.add(mapper(rs));

        } catch (SQLException e) {
            System.out.println("❌ Erreur listage : " + e.getMessage());
        }
        return liste;
    }

    // ─────────────────────────────────────────
    // LISTER PAR CLIENT — jointure + filtre sur id_client
    // Utile pour voir toutes les commandes d'un client précis
    // ─────────────────────────────────────────
   
    public List<Commande> listerParClient(int idClient) {
        List<Commande> liste = new ArrayList<>();
        String sql = SELECT_JOIN + "WHERE c.id_client = ?";

        try (
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idClient);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) liste.add(mapper(rs));

        } catch (SQLException e) {
            System.out.println("❌ Erreur listerParClient : " + e.getMessage());
        }
        return liste;
    }

   
}
