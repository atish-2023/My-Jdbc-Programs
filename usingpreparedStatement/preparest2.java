// retrieve the data from database table


package prepare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class preparest2 {
	
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
			
			
			PreparedStatement ps = conn.prepareStatement("select * from mobile");
			
			
			
			
			
			ResultSet rs  = ps.executeQuery();
			
			while(rs.next())
			{
				String name1 = rs.getString("name");
				int storage1 = rs.getInt("storage");
				int price1 =  rs.getInt("price");
				String network1 = rs.getString("network");
				float display1= rs.getFloat("display");
				
				System.out.println("name : " + name1);
				System.out.println("storage : " + storage1);
				System.out.println("price : " + price1);
				System.out.println("network : " + network1);
				System.out.println("display : " + display1);
				
				System.out.println("......................");
				
			}
		}
		catch(SQLException e)
		{
		   e.printStackTrace();
		}
		
		
		
		

	}

}
