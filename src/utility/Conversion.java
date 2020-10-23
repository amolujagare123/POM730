package utility;

public class Conversion {

    public static  String convertcountry(String shortCountry)
    {
        String convertedCountry ="";

        switch (shortCountry)
        {
            case "IN" : convertedCountry = "India"; break;
            case "CN" : convertedCountry = "China"; break;
            case "CO" : convertedCountry = "Colombia"; break;
            case "CU" : convertedCountry = "Cuba"; break;

        }

        return  convertedCountry;
    }
    


}
