package comptebancaire;

import etatcivil.Personne;

public class PersonnePhysique extends Personne implements Client {

    public PersonnePhysique(String nom, String[] prenom, FrenchGregorianCalendar naissance) {
        super(nom, prenom, naissance);
    }
    
    @Override
      public String identification() {return toString();}

}
