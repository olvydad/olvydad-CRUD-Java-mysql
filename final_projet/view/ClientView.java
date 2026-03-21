package org.final_projet.view;

import java.util.List;
import java.util.Scanner;
import org.final_projet.controleur.ControleurClient;
import org.final_projet.entites.Client;
import org.final_projet.teste.Test;

public class ClientView {

    public static void AjouterClient() {
        Scanner max = new Scanner(System.in);
        System.out.println("====ENREGISTREMENT DE CLIENT====");
        System.out.println("Entrez le nom: ");
        String nom = max.nextLine();
        while (Test.moC(nom) || nom.isBlank()) {
            System.out.println("Nom obligatoire et pas de chifre!");
            System.out.print("nom:");
            nom = max.nextLine();
        }

        System.out.println("Entrez le prenom: ");
        String prenom = max.nextLine();
        while (Test.moC(prenom) || prenom.isBlank()) {
            System.out.println("prenom obligatoire et pas de chifre!");
            System.out.print("prenom:");
            prenom = max.nextLine();
        }

        System.out.println("Entrez l'adresse: ");
        String adresse = max.nextLine();
        while (adresse.isBlank()) {
            System.out.println("Poste obligatoire!");
            System.out.print("adresse:");
            adresse = max.nextLine();
        }
        int telephone;
        System.out.println("Entrez le telephone: ");
        telephone = Test.verifPhone();
               ControleurClient.AjouterClient(nom, prenom, adresse, telephone);
               System.out.println("Client ajoute avec succes!");
    }

    public static void AfficherAllClient() {
        List<Client> liste = ControleurClient.AfficheClient();
        System.out.println("======LISTE DES CLIENTS======");
        for (Client c : liste) {
            System.out.println("-------------------------------");
            System.out.println("Id: " + c.getId() + "\nNom: "
                    + c.getNom()
                    + "\nAdresse: "
                    + c.getAdresse()
            );
            System.out.println("-------------------------------");
        }
    }

    public static Client ModiffieClient() {
        Scanner max = new Scanner(System.in);
        Client c = null;
        List<Client> liste = ControleurClient.AfficheClient();
        System.out.println("Entrez l'id a modiffier! ");
        int id = Test.verifInt();
        boolean v = false;
        for (Client cl : liste) {
            if (cl.getId() == id) {
                v = true;
                System.out.println("====MODIFFICATION DE CLIENT====");
                System.out.println("Entrez le nom: ");
                String nom = max.nextLine();
                while (Test.moC(nom) || nom.isBlank()) {
                    System.out.println("Nom obligatoire et pas de chifre!");
                    System.out.print("nom:");
                    nom = max.nextLine();
                }

                System.out.println("Entrez le prenom: ");
                String prenom = max.nextLine();
                while (Test.moC(prenom) || prenom.isBlank()) {
                    System.out.println("prenom obligatoire et pas de chifre!");
                    System.out.print("prenom:");
                    prenom = max.nextLine();
                }

                System.out.println("Entrez l'adresse: ");
                String adresse = max.nextLine();
                while (adresse.isBlank()) {
                    System.out.println("Adresse obligatoire!");
                    System.out.print("Adresse:");
                    adresse = max.nextLine();
                }

                int telephone;
                System.out.println("Entrez le telephone: ");
                telephone = Test.verifPhone();
                c = new Client(id, nom, prenom, adresse, telephone);
                ControleurClient.ModiffieClient(c);
                System.out.println("Modification reusie!");
            }

        }
        if (v == false) {
            System.out.println("Client non trouve!");
        }
        return c;

    }

    public static void SupprimeClient() {
        Scanner max = new Scanner(System.in);
        Client c = null;
        List<Client> liste = ControleurClient.AfficheClient();
        System.out.println("Entrez l'id a suprimer! ");
        int id = Test.verifInt();
        boolean v = false;
        for (Client cl : liste) {
            if (cl.getId() == id) {
                v = true;
                ControleurClient.SupprimeClient(id);
                System.out.println("Client suprimer avec succes!");
            }
        }
        if (v == false) {
            System.out.println("Client non trouver!");
        }
    }

    public static void AfficherUn() {
        int id;
        Scanner max = new Scanner(System.in);
        if (Test.choix() == 1) {
            System.out.println("Entrez l'id du client!");
            id = Test.verifInt();
            Client cl = ControleurClient.AfficherId(id);
            if (cl != null) {
                System.out.println("--------Info de " + cl.getNom());
                System.out.println("Id: " + cl.getId());
                System.out.println("Nom: " + cl.getNom());
                System.out.println("Prenom: " + cl.getPrenom());
                System.out.println("poste: " + cl.getAdresse());
                System.out.println("Salaire: " + cl.getTelephone());
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
            Client cl = ControleurClient.AfficherNom(nom);
            if (cl != null) {
                System.out.println("--------Info de " + cl.getNom());
                System.out.println("Id: " + cl.getId());
                System.out.println("Nom: " + cl.getNom());
                System.out.println("Prenom: " + cl.getPrenom());
                System.out.println("poste: " + cl.getAdresse());
                System.out.println("Salaire: " + cl.getTelephone());
            } else {
                System.out.println("Client non troure!");
            }
        }
    }

}
