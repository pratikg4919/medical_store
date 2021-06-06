import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
public class vdate{
   public static boolean validateJavaDate(String strDate)
   {
	/* Check if date is 'null' */
	if (strDate.trim().equals(""))
	{
	    return true;
	}
	/* Date is not 'null' */
	else
	{
	    /*
	     * Set preferred date format,
	     * For example MM-dd-yyyy, MM.dd.yyyy,dd.MM.yyyy etc.*/
	    SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy/mm/dd");
	    sdfrmt.setLenient(false);
	    /* Create Date object
	     * parse the string into date 
             */
	    try
	    {
	        Date javaDate = sdfrmt.parse(strDate); 
	        //System.out.println(strDate+" is valid date format");
	    }
	    /* Date format is invalid */
	    catch (ParseException e)
	    {
	        //System.out.println(strDate+" is Invalid Date format");
	        return false;
	    }
	    /* Return true if date format is valid */
	    return true;
	}
   }
   public static void main(String args[]){
   
   	String str="2016/09/04";
   	if(validateJavaDate(str))
   	{
   		System.out.println("Valid");
   	}
   	String st="04/09/2020";
   	if(validateJavaDate(st))
   	{
   		System.out.println("Valid");
   	}
   	else
   	{
		System.out.println("InValid");   		
   	}
   }
}

