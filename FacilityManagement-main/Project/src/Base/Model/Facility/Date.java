package Base.Model.Facility;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Date {

    public static java.util.Date parseDate(String date){
        try{
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        }
        catch(ParseException e){
            return null;
        }
    }
}
