
package org.final_projet.teste;

import java.util.Scanner;


public class Test {
    public static boolean moC(String mo) {
        for (int i = 0; i < mo.length(); i++) {
            char c = mo.charAt(i);
            if (c >= '0' && c <= '9') {
                return true;
            }
        }
        return false;
    }

    public static int choix() {
        while (true) {
            try {
                System.out.println("Entrez 1 pour recherche par id!\n Entrez 2 pour recherche par nom!");
                int choix = verifInt();
                if(choix==1 || choix==2){
                return choix;}
                else{System.out.println("Choix invalide!");}
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
                System.out.println("Veillez rentrer un chifie!");
                max.nextLine();
            }
        }
    }
    
     public static double verifDouble() {
        while (true) {
            try {
                double choix = max.nextDouble();
                max.nextLine();
                return choix;
            } catch (Exception e) {
                System.out.println("Veillez rentrer un chifie!");
                max.nextLine();
            }
        }
    }

     public static int verifPhone() {
        while (true) {
            try {int telephone=max.nextInt();
                 while (telephone > 60000000 && telephone < 20000000) {
            System.out.println(" obligatoire et avec 8 chiffres et commence par 2,3,4 ou 5! ");
            System.out.println("telephone: ");
            telephone = max.nextInt();
        }
            return telephone;
            } catch (Exception e) {
                System.out.println("Veillez rentrer un chifie!");
                max.nextLine();
            }
        }
    }
     
     
      public static boolean verifchoix() {
        boolean v=true;
        while (v) {
            try {
                System.out.println("Entrez 1 Si oui!\nEntrez 0 si non!");
                int choix = verifInt();
                switch (choix) {
                    case 1 -> v=true;
                    case 0 -> v=false;
                    default -> System.out.println("Choix invalide!");
                }
            } catch (Exception e) {
                System.out.println("Veillez rentrer un chifie comme demande!");
                max.nextLine();
            }
        }
        return v;
    }

}
