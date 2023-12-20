package comptebancaire;

import java.util.*;
import java.text.*;

public class FrenchGregorianCalendar extends GregorianCalendar{

    public FrenchGregorianCalendar() {
        super();
    }

    public FrenchGregorianCalendar(int year, int month, int dayOfMonth) {
        super(year, month, dayOfMonth);
    }
   
    public String toString(String format) {
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        return sdf.format(this.getTime());
    } 

    @Override
    public String toString() {
        return toString("dd mm YYYY");
    } 


}
