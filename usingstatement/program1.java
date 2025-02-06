// retrive the data


package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class program1 {
	
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
			
			
			ResultSet rs = st.executeQuery("select * from mobile");
			
			while(rs.next())
			{
				String name  = rs.getString("name");
				int storage = rs.getInt("storage");
				int price = rs.getInt("price");
				String network = rs.getString("network");
				float display = rs.getFloat("display");
				
				System.out.println("mobile name : " + name);
				System.out.println("storage  : " + storage);
				System.out.println("price : " + price);
				System.out.println("network : " + network);
				System.out.println("display size  : " + display);
				
				System.out.println("--------------------------");
			}
		}
		catch(SQLException e)
		{
		   e.printStackTrace();
		}
		
		
		
		

	}

}
