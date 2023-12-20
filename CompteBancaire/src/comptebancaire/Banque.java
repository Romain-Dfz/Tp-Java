package comptebancaire;

public class Banque {
    public static void main(String[] args) {
        PersonneMorale aricia=new PersonneMorale("Aricia",412908048);
        String[] prenoms={"François"};
        PersonnePhysique francois=new PersonnePhysique("Bonneville",
                prenoms,
                new FrenchGregorianCalendar(1966,13,12));
        
        CompteEpargne ce=new CompteEpargne(francois,0.2f);
        ce.depot(500,new FrenchGregorianCalendar(),"économie");
        System.out.println(ce.listeOperations(10));
    }
}
