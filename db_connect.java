import java.sql.*;
public class db_connect
{
	public Connection con=null;
	String url = "jdbc:postgresql://localhost:5432/pharmacy";
	String user = "postgres";
	String password = "Pratik@123";
	
	
	db_connect()
	{
		
	}
		public Connection getConnection()
		{
			if(con!=null)
			{
				return con;
			}
			try
			{
					Class.forName("org.postgresql.Driver");
					
					String url = "jdbc:postgresql://localhost:5432/pharmacy";
					String user = "postgres";
					String password = "Pratik@123";
					con = DriverManager.getConnection(url,user,password);
					return con;
					//System.out.println(con);	
			}
			catch(Exception e)
			{
				System.out.println("Exception caught-"+e);
			}
			return null;
		}
/*	public static void main(String[] args)
	{
		 db_connect obj =new db_connect();
		 obj.getConnection();
		 System.out.println(obj);
	}
	*/
}

