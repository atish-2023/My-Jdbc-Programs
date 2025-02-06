
// menu driven program

package postgrejdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class testst {

	private static final String url = "jdbc:postgresql://localhost:5432/teaacherdata";
	private static final String user = "postgres";
	private static final String password = "1193";

	public static void main(String[] args) {

		try {

			Class.forName("org.postgresql.Driver");

			System.out.println("Driver loaded successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();

			Scanner sc = new Scanner(System.in);

			
			

			while (true) {
				
				System.out.println("------------------------------------------------------------------------------");

				System.out.println(" Welcome  to the school  ");

				System.out.println("1. Insert the data ");

				System.out.println("2. Update the data ");

				System.out.println("3. Delete the data ");

				System.out.println("4. Retrieve the data ");

				System.out.println("------------------------------------------------------------------------------");

				System.out.println("Enter your choice : ");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("HOw many data you want to insert : ");
					int size = sc.nextInt();

					for (int i = 0; i < size; i++) {
						System.out.println("enter teacher id : ");
						int id = sc.nextInt();

						System.out.println("enter teacher name : ");
						String name = sc.next();

						System.out.println("enter teacher experience : ");
						String experience = sc.next();

						System.out.println("enter teacher salary : ");
						int salary = sc.nextInt();

						String query = String.format(
								"insert into teacher(id,name,experience,salary) values(%d,'%s','%s',%d)", id, name,
								experience, salary);

						st.addBatch(query);

						int arr[] = st.executeBatch();

						for (int i1 = 0; i1 < arr.length; i1++) {
							if (arr[i1] == 0) {
								System.out.println("query " + (i1 + 1) + "not executed successfully ");
							}

						}
						System.out.println("Data inserted successfully!");

						System.out.println("Do you want to enter more data? (Y/N)");
						String choice1 = sc.next();

						if (choice1.equalsIgnoreCase("N")) {
							break;
						}
					}
					break;

				case 2:
					System.out.println("Enter the column name you want to update: ");
					String columnName = sc.next();

					System.out.println("You want to update the column: " + columnName);

					System.out.println("Enter the value to update: ");

					String value = sc.next();

					System.out.println("Enter the id of the record you want to update: ");
					int id1 = sc.nextInt();

					String query = String.format("update teacher set %s = '%s' where id = %d ", columnName, value, id1);

					int count = st.executeUpdate(query);

					if (count > 0) {
						System.out.println("data updated  successfully ");
					} else {
						System.out.println("not data updated successfully");
					}
					break;
				case 3 : 
					
					

					System.out.println("Enter the id u want to delete : ");
					int id2 = sc.nextInt();

					String query1 = String.format("delete from teacher where id = '%d'",id2);

					int count1 = st.executeUpdate(query1);

					if (count1 > 0) {
						System.out.println("data deleted successfully ");
					} else {
						System.out.println("not data deleted successfully");
					}
					break;
					
				case 4: 
					
					
					String query2 = "select * from teacher";
					
					ResultSet rs = st.executeQuery(query2);
					
					while(rs.next())
					{
						int ids = rs.getInt("id");
						String nm = rs.getString("name");
						String ex = rs.getString("experience");
						int sl = rs.getInt("salary");
						
						
						System.out.println("id is : " +ids);
						System.out.println("name is : " +nm);
						System.out.println("experience is : " +ex);
						System.out.println("salary is : " +sl);
					}
					break;
				default:
					System.out.println("invalid choice ");
					break;
						

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
