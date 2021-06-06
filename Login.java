import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Exception;
import java.sql.*;

class LoginForm extends JFrame implements ActionListener
{
	JFrame fr;
	JLabel lblusername,lblpaswd,lblshow, lbllogin, invalid, img;
	JTextField tfusername;
	JPasswordField pswd;
	JButton btnclear,btnlogin;
	JCheckBox showpass;
	public static String username;	
	LoginForm()
	{
		fr = new JFrame();
		fr.setTitle("Login Form");
		fr.setSize(900,850);
		fr.setVisible(true);
		fr.setLayout(null);
		fr.getContentPane().setBackground(Color.decode("#735c54"));	//735c54
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Image icon = Toolkit.getDefaultToolkit().getImage("login1.png");    
		fr.setIconImage(icon);    

		lbllogin = new JLabel("<html><font size='10' color=white><b>LOGIN</b></font></html>");
		lbllogin.setBounds(510,30,135,30);	
		fr.add(lbllogin);
		
		lblusername= new JLabel("<html><font size='4' color=white><b>Username</b></font></html>");
		lblusername.setBounds(430,100,100,30);
		fr.add(lblusername);
		
		tfusername = new JTextField(30);
		tfusername.setBounds(530,100,150,30);
		fr.add(tfusername);
		
		lblpaswd = new JLabel("<html><font size='4' color=white><b>Password</b></font></html>");
		lblpaswd.setBounds(430,150,100,30);
		fr.add(lblpaswd);
		
		pswd = new JPasswordField(30);
		pswd.setBounds(530,150,150,30);
		fr.add(pswd);
		
		showpass = new JCheckBox();
		showpass.setBackground(Color.WHITE);
		showpass.setOpaque(true);
		showpass.setBounds(530,210,20,20);
		fr.add(showpass);
		
	
		lblshow = new JLabel("<html><font size='3' color=white>Show Password</font></html>");
		lblshow.setBounds(560,205,150,30);
		fr.add(lblshow);
		
		btnclear = new JButton("clear");
		btnclear.setBackground(Color.WHITE);
		btnclear.setOpaque(true);
		btnclear.setBounds(430,250,90,40);
		fr.add(btnclear);
		
		img = new JLabel(new ImageIcon("login1.png"));
		img.setBounds(450,350,220,240);
		fr.add(img);
		
		btnlogin = new JButton("LOGIN");
		btnlogin.setBackground(Color.WHITE);
		btnlogin.setOpaque(true);
		btnlogin.setBounds(630,250,90,40);
		fr.add(btnlogin);
  		
		btnclear.addActionListener(this);
		btnlogin.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnclear)
		{
			tfusername.setText(null);
			pswd.setText(null);
		}
		else if(ae.getSource()==btnlogin)
		{
			try{
				Class.forName("org.postgresql.Driver");
			
				String url = "jdbc:postgresql://localhost:5432/pharmacy";
				String user = "postgres";
				String password = "Pratik@123";
				Connection conn = DriverManager.getConnection(url,user,password);
			

			String email = tfusername.getText();
			String pass = pswd.getText();
			String query = "select * from login where email=? and password=?";
			
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1,email);
			pstmt.setString(2,pass);
			ResultSet rs=pstmt.executeQuery();
			int count=0;
			while(rs.next())
			{
				count++;
			}
			if (count!=1)
			{
				tfusername.setText("");
				pswd.setText(null);
				JOptionPane.showMessageDialog (null, "Invalid Username or Password");
			}
			else
			{
				username = email;
				fr.dispose();
				new SecondFrame();				
			}
			}			
			catch(Exception e)
			{
				System.out.println("Exception caught-"+e);
			}
		}  
 		
	}
	

/*public static void cdb()
	{	
		try
		{
		Class.forName("org.postgresql.Driver");
			
		String url = "jdbc:postgresql://localhost:5432/pharmacy";
		String user = "postgres";
		String password = "Pratik@123";
		Connection conn = DriverManager.getConnection(url,user,password);
		 
		}
		catch(Exception e)
		{
			System.out.println("Exception caught"+e);
		}
	}
*/	
}


	public class Login
	{
		public static void main(String[] args)
		{
			try
			{
			
				new LoginForm();
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
	}
