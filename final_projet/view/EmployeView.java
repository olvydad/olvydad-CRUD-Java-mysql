package org.final_projet.view;
import java.util.List;
import org.final_projet.controleur.ControleurEmploye;
import java.util.Scanner;
import org.final_projet.entites.Employe;
import org.final_projet.teste.Test;
public class EmployeView {
    
    public static void AjouterEmp(){
        Scanner max=new Scanner(System.in);
        System.out.println("====AJOUT D'EMPLOYE====");
        System.out.println("Entrez le nom: ");
        String nom=max.nextLine();
        while(Test.moC(nom)||nom.isBlank()){
                System.out.println("Nom obligatoire et pas de chifre!");
                System.out.print("nom:");
            nom =max.nextLine();}
        
        System.out.println("Entrez le prenom: ");
        String prenom=max.nextLine();
                 while(Test.moC(prenom)||prenom.isBlank()){
                System.out.println("prenom obligatoire et pas de chifre!");
                System.out.print("prenom:");
            prenom =max.nextLine();}

        System.out.println("Entrez le poste: ");
        String poste=max.nextLine();
         while(Test.moC(poste)||poste.isBlank()){
                System.out.println("Poste obligatoire et pas de chifre!");
                System.out.print("poste:");
            poste =max.nextLine();}
         
        System.out.println("Entrez le salaire: ");
        double salaire =max.nextDouble();
        while(salaire<=0 ){
            System.out.println("Salaire obligatoire et >0 !");
            System.out.println("salaire: ");
            salaire =max.nextDouble();
        }
        ControleurEmploye.AjouterEmployer(nom, prenom, poste, salaire);
        System.out.println("Employe ajoute avec succes!");
    }
    
    
    public static void AfficherAllEmp(){
        List<Employe> liste=ControleurEmploye.AfficheEmploye();
        System.out.println("======LISTE DES EMPLOYES======");
        for(Employe e: liste){
            System.out.println("-------------------------------");
    System.out.println("Id: "+e.getId()+"\nNom: "+
                           e.getNom()+
                           "\nPoste: "+
                           e.getPoste()
                           );
            System.out.println("-------------------------------");
        }
}
    
    public static Employe ModiffieEmp(){
        Scanner max=new Scanner(System.in);
        Employe e = null;
        List<Employe> liste=ControleurEmploye.AfficheEmploye();
        System.out.println("Entrez l'id a modiffier! ");
        int id=Test.verifInt();
        boolean v=false;
        for(Employe em: liste){
            if(em.getId()==id){
                v=true;
                System.out.println("====MODIFFICATION D'EMPLOYE====");
        System.out.println("Entrez le nom: ");
        String nom=max.nextLine();
        while(Test.moC(nom)||nom.isBlank()){
                System.out.println("Nom obligatoire et pas de chifre!");
                System.out.print("nom:");
            nom =max.nextLine();}
        
        System.out.println("Entrez le prenom: ");
        String prenom=max.nextLine();
                 while(Test.moC(prenom)||prenom.isBlank()){
                System.out.println("prenom obligatoire et pas de chifre!");
                System.out.print("prenom:");
            prenom =max.nextLine();}

        System.out.println("Entrez le poste: ");
        String poste=max.nextLine();
         while(Test.moC(poste)||poste.isBlank()){
                System.out.println("Poste obligatoire et pas de chifre!");
                System.out.print("poste:");
            poste =max.nextLine();}
         
        System.out.println("Entrez le salaire: ");
        double salaire =max.nextDouble();
        while(salaire<=0 ){
            System.out.println("Salaire obligatoire et >0 !");
            System.out.println("salaire: ");
            salaire =max.nextDouble();
        }
         e=new Employe(id,nom,prenom,poste,salaire);
        ControleurEmploye.ModiffieEmploye(e);
                System.out.println("Modification reusie!");
            }
            
        }
        if(v==false){
            System.out.println("Employe non trouve!");
        }
        return e;
        
        }

   public static void SupprimeEmp(){
             Scanner max=new Scanner(System.in);
        Employe e = null;
        List<Employe> liste=ControleurEmploye.AfficheEmploye();
        System.out.println("Entrez l'id a suprimer! ");
        int id=Test.verifInt();
        boolean v=false;
        for(Employe em: liste){
            if(em.getId()==id){
                v=true;
                ControleurEmploye.SupprimeEmploye(id);
                System.out.println("Employe suprimer avec succes!");
        }
        }
        if(v==false){
            System.out.println("Employe non trouver!");
        }
   }


   public static void AfficherUn(){
       int id;
       Scanner max=new Scanner(System.in);
       if (Test.choix()==1){
                System.out.println("Entrez l'id de l'employe!");
                id=Test.verifInt();
        Employe emp=ControleurEmploye.AfficherId(id);
                if(emp != null){
                    System.out.println("--------Info de "+emp.getNom());
                    System.out.println("Id: "+emp.getId());
                    System.out.println("Nom: "+emp.getNom());
                    System.out.println("Prenom: "+emp.getPrenom());
                    System.out.println("poste: "+emp.getPoste());
                    System.out.println("Salaire: "+emp.getSalaire());}
       else{
                    System.out.println("Employe non troure!");
                }}
       else {
           System.out.println("Entrez le nom de l'employe!");
           String nom;
           nom=max.nextLine();
            while(Test.moC(nom)||nom.isBlank()){
                System.out.println("Nom obligatoire et pas de chifre!");
                System.out.print("nom:");
            nom =max.nextLine();}
           Employe empl=ControleurEmploye.AfficherNom(nom);
                if(empl != null){
                     System.out.println("--------Info de "+empl.getNom());
                    System.out.println("Id: "+empl.getId());
                    System.out.println("Nom: "+empl.getNom());
                    System.out.println("Prenom: "+empl.getPrenom());
                    System.out.println("poste: "+empl.getPoste());
                    System.out.println("Salaire: "+empl.getSalaire());
       }else{
                    System.out.println("Employe non troure!");
                } 
                }
   }}
                
                
   
   
    

