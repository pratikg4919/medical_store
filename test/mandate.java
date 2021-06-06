import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class mandate

	public static boole{an manDate(String date2)
	{
		try
		{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		String date1=dateFormat.format(date);
		Date cdate = dateFormat.parse(date1);
            	Date mdate = dateFormat.parse(date2);
            	
            	if(cdate.after(mdate))
            	{
            		return true;
            	}
            	else
            	{
            		return false;
            	}
            	}
            	catch(Exception e)
            	{
            		System.out.println("Exception-"+e);
            	}
            	return true;
	}

	public static void main(String[] args)
	{
		String checkdate="2021/05/17";
		System.out.println(manDate(checkdate));
	}
}

