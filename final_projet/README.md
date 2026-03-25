# CRUD-Java-mysql
 // AJOUTER PRODUIT A COMMANDE
   
    public void ajouterProduitACommande(int idCommande, Produit produit) {
        try {
            Commande c = dao.rechercherParId(idCommande);

            if (c == null) {
                System.out.println(" Commande introuvable !");
                return;
            }

            c.ajouterProduit(produit);
            c.calculerMontant();

            dao.modifier(c);

            System.out.println(" Produit ajouté. Nouveau montant : " + c.getMontant());

        } catch (Exception e) {
            System.out.println(" Erreur ajout produit : " + e.getMessage());
        }
    }