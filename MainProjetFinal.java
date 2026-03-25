package org.final_projet;


import org.final_projet.controleur.ControleurClient;
import org.final_projet.controleur.ControleurEmploye;
import org.final_projet.controleur.ControleurProduit;
import org.final_projet.teste.Test;
import org.final_projet.view.CommandeView;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import org.final_projet.view.CommandeProduitView;

public class MainProjetFinal {

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out,true,"UTF-8"));
       boolean v =true;
        System.out.println("======BIENVENUE A OLYMAX======");
        while (v) {
            System.out.println("======MENUE====== ");
            System.out.println("1) Gestion des employes");
            System.out.println("2) Gestion  des clients.");
            System.out.println("3) Gestion des Produits");
            System.out.println("4) Gestion des commandes.");
            System.out.println("0) Quitter");
            int choix = Test.verifInt();
            switch (choix) {
                case 1 ->
                    ControleurEmploye.MenueEmploye();
                case 2 ->
                    ControleurClient.MenueClient();
                case 3 -> 
                    ControleurProduit.MenueProduit();
                case 4-> {CommandeView view = new CommandeView();
                        view.afficherMenu();}
                case 0 ->
                    v = false;
            }
        }
    }
}
