package utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversion {

    public static String convertCountry(String shortCountry) // --> db
    {
        String convertedCountry="";

        switch (shortCountry)
        {
            case "IN" : convertedCountry="India";break;
            case "PL" : convertedCountry="Poland";break;
            case "RU" : convertedCountry="Russia";break;
            case "UA" : convertedCountry="Ukraine";break;
            case "SG" : convertedCountry="Singapore";break;
            case "SE" : convertedCountry="Sweden";break;
        }


        return convertedCountry;
    }

    public static String getGender(String genderId)
    {
        String gender = "";

        switch (genderId)
        {
            case "0" : gender = "Male";break;
            case "1" : gender = "Female";break;
            case "2" : gender = "Other";break;
        }


        return  gender;
    }


    // 10/29/1985 → MM/dd/yyyy

    public static String convertDate(String dbDate) throws ParseException // yyyy-MM-dd
    {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dbDate);

        return  new SimpleDateFormat("MM/dd/yyyy").format(date);
    }
}
