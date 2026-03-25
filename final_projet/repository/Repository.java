
package org.final_projet.repository;

import org.final_projet.entites.CommandeProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeProduitRepository extends JpaRepository<CommandeProduit, Integer> {
    // Tu peux ajouter des méthodes personnalisées si besoin
    // Exemple : List<CommandeProduit> findByIdCommande(int idCommande);
}
