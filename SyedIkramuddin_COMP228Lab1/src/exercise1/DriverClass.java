package exercise1;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DriverClass {
    public static void main(String [] args){
        Singers singer1 = new Singers();
        System.out.println(" Displaying default values:");
        System.out.println(singer1);


        singer1.setSinger(1,"John","Scarborough, Canada",LocalDate.of(1971,05,03),751);
        System.out.println("\n Displaying After setting values");
        System.out.println(singer1);

        singer1.setSingerId(11);
        singer1.setSingerName("Saira");
        singer1.setSingerAddress("Brampton, Canada");
        singer1.setDateOfBirth( LocalDate.of(2000,12,04));
        singer1.setNumberOfAlbumsPublished(1109);

        System.out.println("\n Displaying after changing values");
        System.out.println("singer Id = "+ singer1.getSingerId());
        System.out.println("singer Name = "+ singer1.getSingerName());
        System.out.println("singer Address = "+ singer1.getSingerAddress());
        System.out.println("singer date of birth = "+ singer1.getDateOfBirth());
        System.out.println("singer number of albums published = "+ singer1.getNumberOfAlbumsPublished());
    }
}
