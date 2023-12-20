package comptebancaire;

public class PersonneMorale implements Client
{ 
  private String nom; 
  private long numeroSiret;
  
 @Override
  public String identification() {return nom+" "+numeroSiret;}
  
  PersonneMorale (String unNom,long numeroSiret)
   {
     nom = unNom;
     this.numeroSiret=numeroSiret;
   }
   
  public String getNom()
  {
    return (nom);
  }  
  
  public String toString() {return identification();}
}
