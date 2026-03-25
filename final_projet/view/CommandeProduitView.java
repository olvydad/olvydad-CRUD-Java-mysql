
package org.final_projet.view;

import java.util.Scanner;
import org.final_projet.controleur.CommandeProduitContr;
import org.final_projet.entites.CommandeProduit;


public class CommandeProduitView {
    private Scanner scanner =new Scanner(System.in);
    private CommandeProduitContr cpc=new CommandeProduitContr();
    public void Menu(){
        while (true){
            System.out.println("-----Menu-----");
            System.out.println("1-Ajouter un produit ");
            System.out.println("2-Supprimer un produit ");
            
            int choix;
            System.out.println("Faites un choix : ");
            choix =scanner.nextInt();
             switch (choix){
                 case 1 -> ajouterProduitCommande();
                 case 2 -> supprimerProduit();
             }
        }
    }
    
    public void ajouterProduitCommande(){
        System.out.println("Entrer l'id du produit: ");
        int id_P=scanner.nextInt();
        System.out.println("Entrer l'id de la commande: ");
        int id_C=scanner.nextInt();
        System.out.println("Entrer la quantite: ");
        int Quantite=scanner.nextInt();
        CommandeProduit cp= new CommandeProduit(id_P,id_C,Quantite);
        cpc.ajouterProduit(cp);
    }
    public void supprimerProduit(){
        System.out.println("Entrer l'id a supprimer: ");
        int id_P=scanner.nextInt();
        cpc.suppimerProduit(id_P);
    }
}
