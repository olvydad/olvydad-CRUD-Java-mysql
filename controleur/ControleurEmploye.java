package org.final_projet.controleur;

import java.util.List;
import org.final_projet.dao.EmployeDAO;
import org.final_projet.entites.Employe;
import org.final_projet.teste.Test;
import org.final_projet.view.EmployeView;

public class ControleurEmploye {

    public static void MenueEmploye() {
        boolean v = true;
        System.out.println("======BONNE GESTION DES EMPLOYES======");
        while (v) {
            System.out.println("======MENUE====== ");
            System.out.println("1) Ajout d'employe.");
            System.out.println("2) Liste  des employeS.");
            System.out.println("3) Recherche d'employe.");
            System.out.println("4) Modification d'employe.");
            System.out.println("5) Suppresion d'employe.");
            System.out.println("0) Quitter!");
            int choix = Test.verifInt();
            switch (choix) {
                case 1 ->
                    EmployeView.AjouterEmp();
                case 2 ->
                    EmployeView.AfficherAllEmp();
                case 3 ->
                    EmployeView.AfficherUn();
              case 4 ->{System.out.println("Etre vous sur de vouloir modifier?");
                            System.out.println("Entrez 1 Si oui!");
                             System.out.println("Entrez 0 si non!");
                              choix = Test.verifInt();
                         if(choix==1){
                    EmployeView.ModiffieEmp();}
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
                    EmployeView.SupprimeEmp();}
                  else if (choix==0){
                             v=true;
                            System.out.println("Suppression annule!");
                         }
                         else {System.out.println("Choix invalide!");}
                    }                case 0 -> {
                    v = false;
                    System.out.println("Aurevoir!");
                }
            }
        }
    }

    public static void AjouterEmployer(String nom, String prenom, String poste, double salaire) {
        Employe e = new Employe(nom, prenom, poste, salaire);
        EmployeDAO.Ajoute(e);
    }

    public static Employe AfficherId(int id) {
        return EmployeDAO.AfficheId(id);
    }

    public static Employe AfficherNom(String nom) {
        return EmployeDAO.AfficheNom(nom);
    }

    public static List<Employe> AfficheEmploye() {
        return EmployeDAO.AfficheAll();
    }

    public static void ModiffieEmploye(Employe e) {
        EmployeDAO.Modifie(e);
    }

    public static void SupprimeEmploye(int id) {
        EmployeDAO.Suprime(id);
    }

}
