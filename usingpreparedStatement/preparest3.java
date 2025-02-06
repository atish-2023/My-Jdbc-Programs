// updating the data from database table

package prepare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class preparest3 {
	
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
			
			
			PreparedStatement ps = conn.prepareStatement("update mobile set price = ? where name = ? ");
			ps.setInt(1,60000 );
			ps.setString(2,"Redmi Note 12");
			
			
			
			
			int count  = ps.executeUpdate();
			
			if(count > 0 )
			{
				System.out.println("data updated successfully ");
			}
			else {
				System.out.println("not data updated successfully");
			}
		}
		catch(SQLException e)
		{
		   e.printStackTrace();
		}
		
		
		
		

	}

}
