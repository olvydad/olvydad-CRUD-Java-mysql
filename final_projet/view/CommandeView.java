package org.final_projet.view;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import org.final_projet.view.CommandeProduitView;
import org.final_projet.controleur.ControleurCommande;
import org.final_projet.entites.Commande;
import org.final_projet.entites.Produit;
import org.final_projet.teste.Test;

public class CommandeView {

    // ✅ NON STATIC
    private ControleurCommande controller;
    private Scanner scanner;

    public CommandeView() {
        controller = new ControleurCommande();
        scanner = new Scanner(System.in);
    }

 
    // MENU PRINCIPAL
  
    public void afficherMenu() {
        int choix = -1;

        while (choix != 0) {
            System.out.println("\n-----------------------------");
            System.out.println("    GESTION DES COMMANDES    ");
            System.out.println("-------------------------------");
            System.out.println("  1. Ajouter une commande     ");
            System.out.println("  2. Ajouter produit dans la commande");
            System.out.println("  3. Modifier une commande    ");
            System.out.println("  4. Supprimer une commande   ");
            System.out.println("  5. Rechercher par ID        ");
            System.out.println("  6. Voir une fiche de commande");
            System.out.println("  7. Lister toutes            ");
            System.out.println("  8. Lister par client        ");
            System.out.println("  0. Quitter                  ");
            System.out.println("--------------------------------");
            System.out.print("👉 Votre choix : ");

            choix = Test.verifInt();

            switch (choix) {
                case 1 -> ajouterCommande();
                case 2-> {CommandeProduitView cp=new CommandeProduitView();
                    cp.ajouterProduitCommande();}
                case 3 -> formulaireModifier();
                case 4 -> formulaireSupprimer();
                case 5 -> formulaireRechercher();
                case 6-> FicheCommande();
                case 7 -> afficherToutesLesCommandes();
                case 8 -> afficherCommandesParClient();
                case 0 -> System.out.println(" Au revoir !");
                default -> System.out.println("️ Choix invalide !");
            }
        }
    }

 
    // AJOUTER
  
    private void ajouterCommande() {
        System.out.println("\n── Ajouter une commande ──");

        System.out.print("ID Client   : ");
        int idClient = Test.verifInt();

        System.out.print("ID Employé  : ");
        int idEmploye = Test.verifInt();


        scanner.nextLine(); 

        System.out.print("Statut : ");
        String statut = scanner.nextLine().trim();

        Date dateCmd = new Date();

        controller.ajouterProduitCommande(dateCmd, statut, idClient, idEmploye);
    }

   
    private void formulaireModifier() {
        System.out.print("ID commande : ");
        int id = Test.verifInt();

        Commande c = controller.rechercherCommande(id);
        if (c == null) return;

        scanner.nextLine();

        System.out.print("Statut : ");
        String statut = scanner.nextLine();

        System.out.print("Montant : ");
        double montant = Test.verifDouble();

        controller.modifierCommande(id, c.getDateCmd(), montant, statut,
                c.getClient().getId(), c.getEmploye().getId());
    }

   
    private void formulaireSupprimer() {
        System.out.print("ID : ");
        int id = Test.verifInt();

        controller.supprimerCommande(id);
    }

    private void FicheCommande(){
        System.out.print("Entrez l'ID de la commande: ");
        int id = Test.verifInt();
        controller.afficherFicheCommande(id);
    }
  
    private void formulaireRechercher() {
        System.out.print("ID : ");
        int id = Test.verifInt();

        Commande c = controller.rechercherCommande(id);
        if (c != null) afficherCommande(c);
    }

  
    private void afficherToutesLesCommandes() {
        List<Commande> liste = controller.listerCommandes();

        if (liste == null || liste.isEmpty()) {
            System.out.println("Aucune commande !");
            return;
        }

        for (Commande c : liste) afficherCommande(c);
    }

  
    private void afficherCommandesParClient() {
        System.out.print("ID client : ");
        int id = Test.verifInt();

        List<Commande> liste = controller.listerCommandesParClient(id);

        if (liste == null || liste.isEmpty()) {
            System.out.println("Aucune commande !");
            return;
        }

        for (Commande c : liste) afficherCommande(c);
    }
   
    private void afficherCommande(Commande c) {
        System.out.println("──────────────");
        System.out.println("ID : " + c.getId());
        System.out.println("Montant : " + c.getMontant());
        System.out.println("Statut : " + c.getStatut());
        System.out.println("Client : " + c.getClient().getNom());
        System.out.println("Employé : " + c.getEmploye().getNom());

        if (c.getProduits() != null) {
            for (Produit p : c.getProduits()) {
                System.out.println("→ " + p.getNom());
            }
        }
    }
}