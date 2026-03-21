package org.final_projet;


import org.final_projet.controleur.ControleurClient;
import org.final_projet.controleur.ControleurEmploye;
import org.final_projet.controleur.ControleurProduit;
import org.final_projet.teste.Test;


public class MainProjetFinal {

    public static void main(String[] args) {
       boolean v =true;
        System.out.println("======BIENVENUE A OLYMAX======");
        while (v) {
            System.out.println("======MENUE====== ");
            System.out.println("1) Gestion des employes");
            System.out.println("2) Gestion  des clients.");
            System.out.println("3) Gestion des Produits");
            //System.out.println("5) Suppresion de client.");
            System.out.println("0) Quitter");
            int choix = Test.verifInt();
            switch (choix) {
                case 1 ->
                    ControleurEmploye.MenueEmploye();
                case 2 ->
                    ControleurClient.MenueClient();
                case 3 -> 
                    ControleurProduit.MenueProduit();
                case 0 ->
                    v = false;
            }
        }
    }
}
