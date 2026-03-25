package org.final_projet.controleur;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.final_projet.dao.CommandeDAO;
import org.final_projet.entites.Client;
import org.final_projet.entites.Commande;
import org.final_projet.entites.Employe;
import org.final_projet.entites.Produit;

public class ControleurCommande {

   
    private final CommandeDAO dao;

    
    public ControleurCommande() {
        dao = new CommandeDAO();
    }

 

    public void afficherFicheCommande(int idCommande) {
        try {
            Commande commande = dao.FicheCommande(idCommande);
            if (commande == null) {
                System.out.println("❌ Commande introuvable !");
                return;
            }

            System.out.println("==================================");
            System.out.println("        FICHE COMMANDE");
            System.out.println("==================================");
            System.out.println("Client : " + commande.getClient().getNom());
            System.out.println("Commande N° : " + commande.getId());
            System.out.println("----------------------------------");
            System.out.println("Produit |\tPU   |\tQté  |\tTotal");

            for (Produit p : commande.getProduits()) {
                System.out.println(p.getNom() + "|\t" + p.getPrixUnitaire() + " |\t" + 
                                   p.getQuantite() + " |\t" + p.getTotalProduit());
            }

            System.out.println("----------------------------------");
            System.out.println("Montant Total : " + commande.getMontant());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // AJOUTER une commande
  
    public void ajouterProduitCommande(Date dateCmd,
                               String statut, int idClient, int idEmploye) {
        try {
            Client client = new Client();
            client.setId(idClient);

            Employe employe = new Employe();
            employe.setId(idEmploye);

            Commande c = new Commande(dateCmd, statut, client, employe);

            CommandeDAO.ajouter(c);

            System.out.println(" Commande ajoutée avec succès !");
        } catch (Exception e) {
            System.out.println(" Erreur ajout : " + e.getMessage());
        }
    }

  
    // MODIFIER
  
    public void modifierCommande(int id, Date dateCmd, double montant,
                                String statut, int idClient, int idEmploye) {
        try {
            Client client = new Client();
            client.setId(idClient);

            Employe employe = new Employe();
            employe.setId(idEmploye);

            Commande c = new Commande(id, dateCmd, montant, statut, client, employe);

            dao.modifier(c);

            System.out.println(" Commande modifiée !");
        } catch (Exception e) {
            System.out.println(" Erreur modification : " + e.getMessage());
        }
    }

 
    // SUPPRIMER
    
    public void supprimerCommande(int id) {
        try {
            dao.supprimer(id);
            System.out.println(" Commande supprimée !");
        } catch (Exception e) {
            System.out.println(" Erreur suppression : " + e.getMessage());
        }
    }

   
    // RECHERCHER PAR ID
   
    public Commande rechercherCommande(int id) {
        try {
            Commande c = dao.rechercherParId(id);

            if (c != null) {
                System.out.println(" Commande trouvée !");
            } else {
                System.out.println(" Commande introuvable !");
            }

            return c;

        } catch (Exception e) {
            System.out.println(" Erreur recherche : " + e.getMessage());
            return null;
        }
    }

  
    // LISTER TOUTES
   
    public List<Commande> listerCommandes() {
        try {
            List<Commande> liste = dao.listerTous();

            if (liste != null) {
                System.out.println(" " + liste.size() + " commande(s) trouvée(s)");
            }

            return liste;

        } catch (Exception e) {
            System.out.println(" Erreur listage : " + e.getMessage());
            return null;
        }
    }

   
    // LISTER PAR CLIENT
    
    public List<Commande> listerCommandesParClient(int idClient) {
        try {
            List<Commande> liste = dao.listerParClient(idClient);

            if (liste != null) {
                System.out.println("✅ " + liste.size() + " commande(s) pour client " + idClient);
            }

            return liste;

        } catch (Exception e) {
            System.out.println(" Erreur listerParClient : " + e.getMessage());
            return null;
        }
    }
  
   
}