
package org.final_projet.entites;


public class Produit {
    private int id;
    private String nom;
    private String categorie;
    private int stock;
    private int quantite;
    private double prix;
    private double totalProduit;

    public double getTotalProduit() {
        return totalProduit;
    }

    public void setTotalProduit(double totalProduit) {
        this.totalProduit = totalProduit;
    }

    public Produit() {
    }
public void setQuantite(int quantite) {
        this.quantite = quantite;  // <- ici on stocke simplement la valeur
    }

    public int getQuantite() {
        return quantite;
    }
    
 public double getPrixUnitaire() {
        return prix;  // <- ici on retourne la valeur
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prix = prixUnitaire;
    }
    public Produit(String nom, String categorie, int stock, double prix) {
        this.nom = nom;
        this.categorie = categorie;
        this.stock = stock;
        this.prix = prix;
    }

    public Produit(int id, String nom, String categorie, int stock, double prix) {
        this.id = id;
        this.nom = nom;
        this.categorie = categorie;
        this.stock = stock;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    
}
