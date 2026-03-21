package org.final_projet.controleur;

import java.util.List;
import org.final_projet.dao.ClientDAO;
import org.final_projet.entites.Client;
import java.util.Scanner;
import org.final_projet.teste.Test;
import org.final_projet.view.ClientView;

public class ControleurClient {

    public static int choix() {
        while (true) {
            try {
                System.out.println("Entrez 1 pour recherche par id!\n Entrez 2 pour recherche par nom!");
                int choix = verifInt();
                return choix;
            } catch (Exception e) {
                System.out.println("Veillez rentrer un chifie selon le menu!");
                max.nextLine();
            }
        }
    }

    static Scanner max = new Scanner(System.in);

    public static int verifInt() {
        while (true) {
            try {
                int choix = max.nextInt();
                max.nextLine();
                return choix;
            } catch (Exception e) {
                System.out.println("Veillez rentrer un chifie selon le menu!");
                max.nextLine();
            }
        }
    }

    public static void MenueClient() {
        boolean b = true;
        System.out.println("======BONNE GESTION DES CLIENTS======");
        while (b) {
            System.out.println("======MENUE====== ");
            System.out.println("1) Ajout de client.");
            System.out.println("2) Liste  des clients.");
            System.out.println("3) Recherche de client.");
            System.out.println("4) Modification de client.");
            System.out.println("5) Suppresion de client.");
            System.out.println("0) Quitter!");
            int choix = verifInt();
            switch (choix) {
                case 1 ->
                    ClientView.AjouterClient();
                case 2 ->
                    ClientView.AfficherAllClient();
                case 3 ->
                    ClientView.AfficherUn();
                case 4 ->{System.out.println("Etre vous sur de vouloir modifier?");
                    if(Test.verifchoix()){
                    ClientView.ModiffieClient();}
                    else{System.out.println("Modification annule!");}}
                case 5 ->{System.out.println("Etre vous sur de vouloir supprimer?");
                    if(Test.verifchoix()){
                    ClientView.SupprimeClient();}
                    else{System.out.println("Suppression annule!");}}
                case 0 -> {
                    b = false;
                    System.out.println("Aurevoir!");
                    break;
                }
            }
        }
    }

    public static void AjouterClient(String nom, String prenom, String adresse, int telephone) {
        Client c = new Client(nom, prenom, adresse, telephone);
        ClientDAO.Ajoute(c);
    }

    public static Client AfficherId(int id) {
        return ClientDAO.AfficheId(id);
    }

    public static Client AfficherNom(String nom) {
        return ClientDAO.AfficheNom(nom);
    }

    public static List<Client> AfficheClient() {
        return ClientDAO.AfficheAll();
    }

    public static void ModiffieClient(Client c) {
        ClientDAO.Modifie(c);
    }

    public static void SupprimeClient(int id) {
        ClientDAO.Suprime(id);
    }

}
