import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Exception;
import java.sql.*;
import java.text.SimpleDateFormat;  
import java.util.Date;
import java.text.ParseException;
import javax.swing.table.*;

public class jtab
{
	JFrame f; 
	JScrollPane sb;      
	JTable tb;  
	DefaultTableModel model; 
	
	jtab()
	{
		f = new JFrame();
		f.setSize(1500,1500);
		f.setVisible(true);
		f.setTitle("HOME");
		f.setLayout(null);
		f.getContentPane().setBackground(Color.decode("#735c54"));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tb = new JTable();  
		sb = new JScrollPane(tb);
		sb.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);  
		sb.setBounds(100, 50, 900, 200);  
		f.add(sb);
		
		model = new DefaultTableModel();
		model.addColumn("id");  
		model.addColumn("Name");  
		model.addColumn("Price");
		model.addColumn("Quantity");
		model.addColumn("Category");
		model.addColumn("Expiry");  
		tb.setModel(model);
		try
		{
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost:5432/pharmacy";
			String user = "postgres";
			String password = "Pratik@123";
			Connection conn = DriverManager.getConnection(url,user,password);
			String query="select mid,name,price,quantity,category,expiry from medicines where name=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			String name="Paracetamol";
			pstmt.setString(1,name);
			ResultSet rs=pstmt.executeQuery();
			if (rs.next())
			{
		        	int id = rs.getInt("mid");
		        	String mname = rs.getString("name");
		        	int price = rs.getInt("price");
		        	int quantity = rs.getInt("quantity");
		        	String category = rs.getString("category");
		        	String expiry = rs.getString("expiry");
		        	model.addRow(new Object[]{id,mname,price,quantity,category,expiry});
		    	}
		}
		catch(Exception e)
		{
			System.out.println("Exception caught-"+e);
		}
	}
	
	   
	public static void main(String[] args)
	{
		new jtab();		
	}
}
