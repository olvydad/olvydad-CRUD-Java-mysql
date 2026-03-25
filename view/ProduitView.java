
package org.final_projet.view;
import java.util.Scanner;
import org.final_projet.controleur.ControleurProduit;
import org.final_projet.entites.Produit;
import org.final_projet.teste.Test;

public class ProduitView {
    static Scanner scanner = new Scanner(System.in);
      
    public static void ajouterProduit(){
        System.out.println("Entrer le nom du produit: ");
        String nom= scanner.nextLine();
        while(Test.moC(nom)||nom.isBlank()){
                System.out.println("Nom obligatoire et pas de chifre!");
                System.out.print("nom:");
            nom =scanner.nextLine();}
        
        System.out.println("Entrer la categorie du produit: ");
        String categorie = scanner.nextLine();
        while(Test.moC(categorie)||categorie.isBlank()){
                System.out.println("Categorie obligatoire et pas de chifre!");
                System.out.print("categorie:");
            categorie =scanner.nextLine();}
        
        System.out.println("Entrer le stock: ");
        int stock =Test.verifInt();
        
        System.out.println("Entrer le prix du produit: ");
        double prix = Test.verifDouble();
        
        ControleurProduit.ajouterProduit(nom, categorie, stock, prix);
    }
    
    public static void AfficherAllProduit(){
        
        for(Produit p:ControleurProduit.afficherProduit()){
            System.out.println("Id: "+p.getId()+"\nNom: "+p.getNom()+
                    "\nCategorie: "+p.getCategorie()+"\nStock: "+p.getStock()+"\nPrix: "+
                    p.getPrix());  
            System.out.println("---------------------------");
        }
    }
    public static void modifierProduit(){
        System.out.println("Enter l'id a modifier: ");
        int id =Test.verifInt();
        boolean b=true;
         for(Produit p:ControleurProduit.afficherProduit()){
             if(id == p.getId()){
                 b=false;
                  System.out.println("Entrer le nom du produit: ");
                 String nom= scanner.nextLine();
        while(Test.moC(nom)||nom.isBlank()){
                System.out.println("Nom obligatoire et pas de chifre!");
                System.out.print("nom:");
            nom =scanner.nextLine();}
        
        System.out.println("Entrer la categorie du produit: ");
        String categorie = scanner.nextLine();
        while(Test.moC(categorie)||categorie.isBlank()){
                System.out.println("Categorie obligatoire et pas de chifre!");
                System.out.print("categorie:");
            categorie =scanner.nextLine();}
        
        System.out.println("Entrer le stock: ");
        int stock =Test.verifInt();
        
        System.out.println("Entrer le prix du produit: ");
        double prix = Test.verifDouble();
        ControleurProduit.modifierProduit(id,nom, categorie, stock, prix);
             } 
         }
         if(b==true){
             System.out.println("Produit non trouver ");
         }
    }
    
    public static void supprimerProduit(){
        System.out.println("Enter l'id a modifier: ");
        int id =scanner.nextInt();
        boolean b=true;
         for(Produit p:ControleurProduit.afficherProduit()){
             if(id == p.getId()){
                 b=false;
                  ControleurProduit.supprimerproduit(id);
             }
         }
         if(b==true){
             System.out.println("Produit non trouver ");
         }
    }
    
    public static void AfficherUn() {
        int id;
        Scanner max = new Scanner(System.in);
        if (Test.choix() == 1) {
            System.out.println("Entrez l'id du client!");
            id = Test.verifInt();
            Produit cl = ControleurProduit.AfficherId(id);
            if (cl != null) {
                System.out.println("--------Info de " + cl.getNom());
                System.out.println("Id: " + cl.getId());
                System.out.println("Nom: " + cl.getNom());
                System.out.println("Categorie: " + cl.getCategorie());
                System.out.println("Stock: " + cl.getStock());
                System.out.println("Prix: " + cl.getPrix());
            } else {
                System.out.println("Client non troure!");
            }
        } else {
            System.out.println("Entrez le nom du client!");
            String nom;
            nom = max.nextLine();
            while (Test.moC(nom) || nom.isBlank()) {
                System.out.println("Nom obligatoire et pas de chifre!");
                System.out.print("nom:");
                nom = max.nextLine();
            }
            Produit cl = ControleurProduit.AfficherNom(nom);
            if (cl != null) {
                System.out.println("--------Info de " + cl.getNom());
                System.out.println("Id: " + cl.getId());
                System.out.println("Nom: " + cl.getNom());
                 System.out.println("Categorie: " + cl.getCategorie());
                System.out.println("Stock: " + cl.getStock());
                System.out.println("Prix: " + cl.getPrix());
            } else {
                System.out.println("Client non troure!");
            }
        }
    }

}
    
