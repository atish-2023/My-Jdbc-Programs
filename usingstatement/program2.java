
// for inserting data into our database table 




package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class program2 {
	
	private static final String url = "jdbc:mysql://127.0.0.1:3306/mydevice";
	private static final String user = "root";
	private static final String password = "Atish@1193";

	public static void main(String[] args) {
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver loaded successfully");
			
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		try 
		{
			Connection conn = DriverManager.getConnection(url,user,password);
			
			
			Statement st = conn.createStatement();
			
			
			
			
			int count  = st.executeUpdate(String.format("insert into mobile(name,storage,price,network,display) values('%s','%d','%d','%s','%f')",  "nokia",4,2000,"2G",6.5));
			
			if(count > 0 )
			{
				System.out.println("data inserted successfully ");
			}
			else {
				System.out.println("not data inserted successfully");
			}
		}
		catch(SQLException e)
		{
		   e.printStackTrace();
		}
		
		
		
		

	}

}
