package comptebancaire;

import java.util.*;


public class CompteBancaire {
	
    static long nbComptes=0;

    private final Client proprietaire;
    protected double solde;
    private final long numeroCompte;
    protected TreeSet<OperationBancaire> listeOperations;

    CompteBancaire (Client proprietaire) 
    {this.proprietaire=proprietaire;
      nbComptes=nbComptes+1;	
      numeroCompte=nbComptes;
      listeOperations=new TreeSet();}

    public double getSolde() {return solde;}	  

    public long getNumeroCompte() {return numeroCompte;}

    public Client getProprietaire() {return proprietaire;}

    @Override
    public String toString() {
            return "Compte n°"+numeroCompte+" "+
                    proprietaire.identification()+" dispose de "+
                    solde+"Euros";
            }

    public double depot(double montant,FrenchGregorianCalendar date,String libelle) {
            solde=solde+montant;
            listeOperations.add(new OperationBancaire(montant,date,libelle));
            return solde;}		

    public double retrait(double montant,String libelle, FrenchGregorianCalendar date) throws BancaireException {
        if (montant> solde) throw new BancaireException("Pas assez d'argent sur le compte");
            else solde=solde-montant;
            listeOperations.add(new OperationBancaire(-montant,date,libelle));
        return solde;
    }
    
    public String listeOperations(int n){
        Iterator<OperationBancaire> i =listeOperations.iterator();
        int index=0;
        String resultat="";
        while (index<n && i.hasNext()) {
            resultat=resultat+i.next().toString()+"\n";
            index=index+1;
        }
        return resultat;
    }
		
}