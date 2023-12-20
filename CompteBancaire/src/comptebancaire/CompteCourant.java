/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comptebancaire;


public class CompteCourant extends CompteBancaire {
    private double montantDecouvertAutorise;
    
    public CompteCourant(Client proprietaire, double decouvert) {
        super(proprietaire);
        montantDecouvertAutorise=decouvert;
    }

    public double getMontantDecouvertAutorise() {
        return montantDecouvertAutorise;
    }
    
    @Override
    public double retrait(double montant,String libelle, FrenchGregorianCalendar date) throws BancaireException {
        if (montant> solde+montantDecouvertAutorise) throw new BancaireException("Pas assez d'argent sur le compte");
            else solde=solde-montant;
        listeOperations.add(new OperationBancaire(montant,date,libelle));
        return solde;
    }

}
