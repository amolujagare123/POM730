package utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversion {


    public static String convertCountry(String shortCountry)
    {
        String fullFormCountry="";

        switch (shortCountry)
        {
            case "IN" : fullFormCountry="India";break;
            case "CN" : fullFormCountry="China";break;
            case "AF" : fullFormCountry="Afghanistan";break;
            case "AU" : fullFormCountry="Australia";break;
        }

        return  fullFormCountry;
    }


    public static  String convertGender(String genderCode)
    {
        String gender="";

        switch (genderCode)
        {
            case "0" : gender="Male";break;
            case "1" : gender="Female";break;
            case "2" : gender="Other";break;
        }


        return gender;
    }


    public static String dateConvert(String dbDate) throws ParseException {

        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dbDate);

        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }


}
