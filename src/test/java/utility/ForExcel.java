package utility;

public class ForExcel {

    public static String convertToNumberString(String decimalNumber) //tx1234
    {
        int temp = 0;
        try {
             temp = (int) Double.parseDouble(decimalNumber);
        }
        catch (Exception e)
        {
            return decimalNumber;
        }
        return ""+temp;
    }
}
