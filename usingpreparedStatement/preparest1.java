// inserted the data into database table

package prepare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class preparest1 {
	
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
			
			
			PreparedStatement ps = conn.prepareStatement("insert into mobile(name,storage,price,network,display) values(?,?,?,?,?)");
			ps.setString(1, "lenovo");
			ps.setInt(2, 512);
			ps.setInt(3, 45000);
			ps.setString(4, "5G");
			ps.setFloat(5,(float) 16.5);
			
			
			
			
			int count  = ps.executeUpdate();
			
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
