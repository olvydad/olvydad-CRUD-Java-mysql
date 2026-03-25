
package org.final_projet.entites;



    import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Commande {

    private int id;
    private Date dateCmd;
    private double montant;
    private String statut;

    // Clés étrangères → objets Java (pas juste des int !)
    private Client client;
    private Employe employe;

    // Liste des produits de la commande (table commande_produit)
    private List<Produit> produits;

    
    public Commande() {
        this.produits = new ArrayList<>();
    }

    // ─────────────────────────────────────────
    // Constructeur complet (avec id) — pour SELECT
    // ─────────────────────────────────────────
    public Commande(int id, Date dateCmd, double montant,
                    String statut, Client client, Employe employe) {
        this.id       = id;
        this.dateCmd  = dateCmd;
        this.montant  = montant;
        this.statut   = statut;
        this.client   = client;
        this.employe  = employe;
        this.produits = new ArrayList<>();
    }

    // ─────────────────────────────────────────
    // Constructeur sans id — pour INSERT
    // ─────────────────────────────────────────
    public Commande(Date dateCmd,
                    String statut, Client client, Employe employe) {
        this.dateCmd  = dateCmd;
        this.montant  = montant;
        this.statut   = statut;
        this.client   = client;
        this.employe  = employe;
        this.produits = new ArrayList<>();
    }

    // ─────────────────────────────────────────
    // Getters & Setters
    // ─────────────────────────────────────────
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Date getDateCmd() { return dateCmd; }
    public void setDateCmd(Date dateCmd) { this.dateCmd = dateCmd; }

    public double getMontant() { return montant; }
    public void setMontant(double montant) { this.montant = montant; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public Employe getEmploye() { return employe; }
    public void setEmploye(Employe employe) { this.employe = employe; }

    public List<Produit> getProduits() { return produits; }
    public void setProduits(List<Produit> produits) { this.produits = produits; }

    // ─────────────────────────────────────────
    // Méthodes utilitaires
    // ─────────────────────────────────────────

    // Ajouter un produit à la commande
    public void ajouterProduit(Produit p) {
        this.produits.add(p);
    }

    // Calculer le montant total automatiquement
    public double calculerMontant() {
        double total = 0;
        for (Produit p : produits) {
            total += p.getPrix();
        }
        this.montant = total;
        return total;
    }

    
    public String toString() {
        return "Commande{" +
               "id=" + id +
               ", date=" + dateCmd +
               ", montant=" + montant +
               ", statut='" + statut + '\'' +
               ", client=" + (client != null ? client.getNom() : "N/A") +
               ", employe=" + (employe != null ? employe.getNom() : "N/A") +
               ", nbProduits=" + produits.size() +
               '}';
    }
}

