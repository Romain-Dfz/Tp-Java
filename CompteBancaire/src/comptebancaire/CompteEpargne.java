/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comptebancaire;


public class CompteEpargne extends CompteBancaire {
    private float tauxInterets;
    
    public CompteEpargne(Client proprietaire,float taux) {
        super(proprietaire);
        tauxInterets=taux;
    }

    public float getTauxInterets() {
        return tauxInterets;
    }
    
    public double calculInterets() {
        solde=solde+solde*tauxInterets;
        return solde;}
    
}
