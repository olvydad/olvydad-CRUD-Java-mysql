
package org.final_projet.controleur;
import org.final_projet.dao.CommandeProduitDAO;
import org.final_projet.entites.CommandeProduit;


public class CommandeProduitContr {
    private CommandeProduitDAO dao=new CommandeProduitDAO();
    
    
    public void ajouterProduit(CommandeProduit cp){
        dao.ajouterProduit(cp);    
    }
    
    public void suppimerProduit(int id){
        dao.supprimerProduit(id);
    }
}
