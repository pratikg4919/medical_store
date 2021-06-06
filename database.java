import java.sql.*;

public class database
{
	public static void cdb()
	{
		try
		{
		Class.forName("org.postgresql.Driver");
			
		String url = "jdbc:postgresql://localhost:5432/pharmacy";
		String user = "postgres";
		String password = "Pratik@123";
		Connection conn = DriverManager.getConnection(url,user,password);
		
		Statement stmt = conn.createStatement();
		String query="create table if not exists login(lid serial primary key,email varchar(15) unique not null,password varchar(15) not null,role char(15) not null default 'user',status char(15) not null default 'active')";
		stmt.execute(query);
		
		query = "create table if not exists users(uid serial primary key,fname char(15) not null,lname char(15),mobile bigint unique not null,address varchar(15) not null,email varchar(15) unique not null,role char(15) not null default 'user')";
		stmt.execute(query);
		
		query = "create table if not exists company(cid serial primary key,cname char(15) unique not null,location char(15) not null,email varchar(30) not null,contact bigint)";
		stmt.execute(query); 
		
		query = "create table if not exists medicines(mid serial primary key,name varchar(15) not null,price int not null,quantity int not null,category char(15) not null,expiry date not null,manufacture date not null,cid int references company(cid))";
		stmt.execute(query);
		
		
		query = "create table if not exists new_sales(nid serial primary key,mid int references medicines(mid),quantity int not null,uid int references users(uid))";
		stmt.execute(query);
		 
		query = "create table if not exists sales(sid serial primary key,date timestamp default current_timestamp,mid int not null references medicines(mid),quantity int not null,nid int references new_sales(nid),uid int references users(uid))";
		stmt.execute(query);
		}
		catch(Exception e)
		{
			System.out.println("Exception caught"+e);
		}
	}

	public static void main(String[] args)
	{
		database dob = new database();
		cdb();
	}
}
			
