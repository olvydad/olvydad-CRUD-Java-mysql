
package org.final_projet.entites;


public class CommandeProduit {
   private int id;

    
    private int id_P;
   private int id_C;
   private int Quantite;
   private double prixUnitaire;

   public CommandeProduit() {
    }
   
    public CommandeProduit(int id_P, int id_C, int Quantite, double prixUnitaire) {
        this.id_P = id_P;
        this.id_C = id_C;
        this.Quantite = Quantite;
        this.prixUnitaire = prixUnitaire;
    }

    public CommandeProduit(int id, int id_P, int id_C, int Quantite, double prixUnitaire) {
        this.id = id;
        this.id_P = id_P;
        this.id_C = id_C;
        this.Quantite = Quantite;
        this.prixUnitaire = prixUnitaire;
    }

    public CommandeProduit(int id_P, int id_C, int Quantite) {
        this.id_P = id_P;
        this.id_C = id_C;
        this.Quantite = Quantite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_P() {
        return id_P;
    }

    public void setId_P(int id_P) {
        this.id_P = id_P;
    }

    public int getId_C() {
        return id_C;
    }

    public void setId_C(int id_C) {
        this.id_C = id_C;
    }

    public int getQuantite() {
        return Quantite;
    }

    public void setQuantite(int Quantite) {
        this.Quantite = Quantite;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
   
   
}
