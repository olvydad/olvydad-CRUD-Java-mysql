
package org.final_projet.controleur;

import java.util.List;
import org.final_projet.dao.ProduitDAO;
import org.final_projet.entites.Produit;
import org.final_projet.teste.Test;
import org.final_projet.view.ProduitView;

public class ControleurProduit {
    public static void MenueProduit() {
        boolean v = true;
        System.out.println("======BONNE GESTION DES PRODUITS======");
        while (v) {
            System.out.println("======MENUE====== ");
            System.out.println("1) Ajout de produit.");
            System.out.println("2) Liste  de produit.");
            System.out.println("3) Recherche de produit..");
            System.out.println("4) Modification de produit.");
            System.out.println("5) Suppresion de produit.");
            System.out.println("0) Quitter!");
            System.out.println("Votre choix:");
            int choix = Test.verifInt();
            switch (choix) {
                case 1 ->
                    ProduitView.ajouterProduit();
                case 2 ->
                    ProduitView.AfficherAllProduit();
                case 3 ->
                    ProduitView.AfficherUn();
               case 4 ->{System.out.println("Etre vous sur de vouloir modifier?");
                            System.out.println("Entrez 1 Si oui!");
                             System.out.println("Entrez 0 si non!");
                              choix = Test.verifInt();
                         if(choix==1){
                    ProduitView.modifierProduit();}
                         else if (choix==0){
                             v=true;
                             System.out.println("Modification annule!");
                         }
                         else {System.out.println("Choix invalide!");}
                    }
                case 5 ->{System.out.println("Etre vous sur de vouloir supprimer?");
                            System.out.println("Entrez 1 Si oui!");
                            System.out.println("Entrez 0 si non!");
                            choix = Test.verifInt();
                 if(choix==1){
                    ProduitView.supprimerProduit();}
                  else if (choix==0){
                             v=true;
                            System.out.println("Suppression annule!");
                         }
                         else {System.out.println("Choix invalide!");}
                    }
                case 0 -> {
                    v = false;
                    System.out.println("Aurevoir!");
                }
            }
        }
    }
    
     public static Produit AfficherId(int id) {
        return ProduitDAO.AfficheId(id);
    }

    public static Produit AfficherNom(String nom) {
        return ProduitDAO.AfficheNom(nom);
    }
    
    public static void ajouterProduit(String nom,String categorie,int stock,double prix){
        Produit p=new Produit(nom,categorie,stock,prix);
        ProduitDAO.ajouterProduit(p);
    }
    public static List<Produit> afficherProduit(){
    List<Produit> li =     ProduitDAO.afficherProduit();
    
          return li; }

    public static void modifierProduit(int id,String nom,String categorie,int stock,double prix ){
       Produit p=new Produit(id,nom,categorie,stock,prix);
        ProduitDAO.modifierProduit(p);  
    }
    public static void supprimerproduit(int id){
        ProduitDAO.supprimerProduit(id);  
    }
}
